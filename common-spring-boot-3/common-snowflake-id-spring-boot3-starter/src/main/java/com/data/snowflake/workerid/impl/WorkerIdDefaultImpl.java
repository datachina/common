package com.data.snowflake.workerid.impl;


import com.data.snowflake.properties.SnowflakeIdProperties;
import com.data.snowflake.workerid.WorkerIdGenerator;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Service;

/**
 * WorkerId 默认实现
 *
 * @author jidaojiuyou
 */
@Service
@ConditionalOnMissingClass({"org.springframework.data.redis.core.RedisTemplate"})
public class WorkerIdDefaultImpl implements WorkerIdGenerator {

    @Resource
    private SnowflakeIdProperties properties;

    /**
     * 生成 workerId
     *
     * @return workerId
     */
    @Override
    public short generateWorkerId() {
        var workerIdBitLength = properties.getWorkerIdBitLength();
        var max = (2 << workerIdBitLength - 1);
        return (short) (Math.random() * max);
    }
}