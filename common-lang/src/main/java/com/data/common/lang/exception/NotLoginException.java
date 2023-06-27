package com.data.common.lang.exception;

/**
 * 未登录异常
 *
 * @author jidaojiuyou
 */
public class NotLoginException extends BaseException {

    /**
     * 无参构造
     */
    public NotLoginException() {
        super("未登录");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public NotLoginException(String message) {
        super(message);
    }
}