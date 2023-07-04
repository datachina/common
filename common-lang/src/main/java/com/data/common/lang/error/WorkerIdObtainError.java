package com.data.common.lang.error;

/**
 * WorkerId 获取失败，为了防止 id 重复应该阻止容器启动
 *
 * @author jidaojiuyou
 */
public class WorkerIdObtainError extends Error {
    public WorkerIdObtainError() {
        super();
    }

    public WorkerIdObtainError(String message) {
        super(message);
    }
}