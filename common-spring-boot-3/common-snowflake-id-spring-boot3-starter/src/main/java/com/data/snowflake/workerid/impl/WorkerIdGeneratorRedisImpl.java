package com.data.snowflake.workerid.impl;

import com.data.common.lang.exception.WorkerIdDoesNotEnoughException;
import com.data.snowflake.model.WorkerIdInstance;
import com.data.snowflake.properties.SnowflakeIdProperties;
import com.data.snowflake.workerid.WorkerIdGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * Redis 获取 WorkerId
 *
 * @author jidaojiuyou
 */
@Component
@EnableScheduling
@ConditionalOnClass(RedisTemplate.class)
@Slf4j
public class WorkerIdGeneratorRedisImpl implements WorkerIdGenerator {

    private static final String KEY = "snowflake_worker_id";
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Value("${spring.application.name:}")
    private String appName;
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private SnowflakeIdProperties properties;

    /**
     * 生成 workerId
     *
     * @return workerId
     */
    @Override
    public short generateWorkerId() throws WorkerIdDoesNotEnoughException {
        if (appName == null || "".equals(appName)) {
            log.warn("空的应用名称可能导致 WorkerId 分配出现问题，建议在 spring.application.name 设置自己的应用名称");
        }
        return getOne();
    }

    private short getOne() throws WorkerIdDoesNotEnoughException {
        // TODO 一般来说，不会同时启动多个副本，而且单个副本获取并计算workId速度足够快。所以基本不会出现重复workId。但是为了安全，还是需要使用分布式锁
        var workerIdBitLength = properties.getWorkerIdBitLength();
        // 允许生成的最大值
        var max = (2 << workerIdBitLength - 1);
        var keys = stringRedisTemplate.keys(KEY + ":" + appName + ":*");
        if (keys == null) {
            keys = new HashSet<>();
        }
        var collect = keys
                .stream()
                .map(key -> key.split(":")[2])
                .filter(key -> !key.contains("-"))
                .filter(key -> {
                    try {
                        Short.parseShort(key);
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .map(Short::parseShort)
                .sorted()
                .toList();
        // 如果 WorkerId 的总数已经达到最大值。抛出异常
        if (collect.size() >= max) {
            throw new WorkerIdDoesNotEnoughException();
        }

        // 找到断截处，设置workerId为断截值
        for (var i = 0; i < collect.size(); i++) {
            if (i != collect.get(i)) {
                var workerId = (short) i;
                setWorkerIdToRedis(workerId);
                return workerId;
            }
        }

        // 若最后都没找到，说明值是连续的，我们直接取集合的大小做WorkerId
        var workerId = (short) collect.size();
        setWorkerIdToRedis(workerId);
        return workerId;
    }

    /**
     * 服务心跳
     * 每隔15秒执行
     */
    @Scheduled(fixedRate = 15000)
    @SneakyThrows(JsonProcessingException.class)
    public void heartbeat() {
        // 单例
        var instance = WorkerIdInstance.getInstance();
        if (instance.getWorkerId() != null) {
            stringRedisTemplate.opsForValue().set(KEY + ":" + appName + ":" + instance.getWorkerId(), objectMapper.writeValueAsString(instance), 30, TimeUnit.SECONDS);
        }
    }

    /**
     * 将 WorkerId 存到 Redis
     *
     * @param workerId workerId
     */
    @SneakyThrows(JsonProcessingException.class)
    private void setWorkerIdToRedis(Short workerId) {
        var instance = WorkerIdInstance.getInstance();
        instance.setWorkerId(workerId);
        stringRedisTemplate.opsForValue().set(KEY + ":" + appName + ":" + instance.getWorkerId(), objectMapper.writeValueAsString(instance), 30, TimeUnit.SECONDS);
    }
}