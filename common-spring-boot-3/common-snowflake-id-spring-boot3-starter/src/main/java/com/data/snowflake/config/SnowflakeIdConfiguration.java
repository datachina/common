package com.data.snowflake.config;

import com.data.common.lang.error.WorkerIdObtainError;
import com.data.common.lang.exception.WorkerIdDoesNotEnoughException;
import com.data.snowflake.properties.SnowflakeIdProperties;
import com.data.snowflake.workerid.WorkerIdGenerator;
import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.RedisConnectionFailureException;

/**
 * 雪花 id 配置
 *
 * @author jidaojiuyou
 */
@AutoConfiguration
@EnableConfigurationProperties(SnowflakeIdProperties.class)
@Slf4j
public class SnowflakeIdConfiguration {

    @Resource
    private SnowflakeIdProperties properties;

    @Resource
    private WorkerIdGenerator workerIdGenerator;

    @PostConstruct
    public void setOptions() {
        var workerIdBitLength = properties.getWorkerIdBitLength();
        // 出错时允许生成的最大值
        var max = (2 << workerIdBitLength - 1);
        var options = new IdGeneratorOptions();
        options.Method = properties.getMethod();
        options.BaseTime = properties.getBaseTime();
        if (properties.getWorkerId() != null) {
            log.warn("使用固定的 Short 值。非单机可能导致 id 重复，当前WorkerId:{}", properties.getWorkerId());
            options.WorkerId = properties.getWorkerId();
        } else {
            try {
                var workerId = workerIdGenerator.generateWorkerId();
                log.info("获取 WorkerId 成功，当前WorkerId:{}", workerId);
                options.WorkerId = workerId;
            } catch (RedisConnectionFailureException e1) {
                if (properties.isAllowDuplicateWorkerId()) {
                    var workerId = (short) (Math.random() * max);
                    options.WorkerId = workerId;
                    log.warn("Redis 连接失败，WorkerId 获取失败。使用随机的 Short 值。非单机可能导致 id 重复，当前WorkerId:{}", workerId);
                } else {
                    throw new WorkerIdObtainError("Redis 连接失败，WorkerId 获取失败");
                }
            } catch (WorkerIdDoesNotEnoughException e2) {
                if (properties.isAllowDuplicateWorkerId()) {
                    var workerId = (short) (Math.random() * max);
                    options.WorkerId = workerId;
                    log.warn("此应用获取的 WorkerId 已达上限，使用随机的 Short 值。非单机可能导致 id 重复，当前WorkerId:{}", workerId);
                } else {
                    throw new WorkerIdObtainError("此应用获取的 WorkerId 已达上限，WorkerId 获取失败");
                }
            }
        }
        options.WorkerIdBitLength = properties.getWorkerIdBitLength();
        options.SeqBitLength = properties.getSeqBitLength();
        options.MaxSeqNumber = properties.getMaxSeqNumber();
        options.MinSeqNumber = properties.getMinSeqNumber();
        options.TopOverCostCount = properties.getTopOverCostCount();
        YitIdHelper.setIdGenerator(options);
    }
}