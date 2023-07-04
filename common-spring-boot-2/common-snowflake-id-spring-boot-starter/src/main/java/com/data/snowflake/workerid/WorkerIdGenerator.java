package com.data.snowflake.workerid;


import com.data.common.lang.exception.WorkerIdDoesNotEnoughException;

/**
 * WorkerId 生成器
 *
 * @author jidaojiuyou
 */
public interface WorkerIdGenerator {
    /**
     * 生成 workerId
     *
     * @return workerId
     * @throws WorkerIdDoesNotEnoughException WorkerId不足
     */
    short generateWorkerId() throws WorkerIdDoesNotEnoughException;
}