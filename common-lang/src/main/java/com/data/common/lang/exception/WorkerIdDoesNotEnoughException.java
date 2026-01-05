package com.data.common.lang.exception;

/**
 * WorkerId 不足异常
 *
 * @author jidaojiuyou
 */
@SuppressWarnings("unused")
public class WorkerIdDoesNotEnoughException extends BaseException {

    /**
     * 无参构造
     */
    public WorkerIdDoesNotEnoughException() {
        super("WorkerId 不够了");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public WorkerIdDoesNotEnoughException(String message) {
        super(message);
    }
}