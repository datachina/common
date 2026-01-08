package com.data.common.lang.error;

/**
 * WorkerId 获取失败，为了防止 id 重复应该阻止容器启动
 *
 * @author jidaojiuyou
 */
@SuppressWarnings("unused")
public class WorkerIdObtainError extends Error {
    /**
     * 无参构造
     */
    public WorkerIdObtainError() {
        super();
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public WorkerIdObtainError(String message) {
        super(message);
    }
}