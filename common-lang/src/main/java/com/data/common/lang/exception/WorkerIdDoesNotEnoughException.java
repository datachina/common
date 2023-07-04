package com.data.common.lang.exception;

/**
 * WorkerId 不足异常
 *
 * @author jidaojiuyou
 */
public class WorkerIdDoesNotEnoughException extends BaseException {

    /**
     * 无参构造
     */
    public WorkerIdDoesNotEnoughException() {
        super("WorkerId不够了");
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