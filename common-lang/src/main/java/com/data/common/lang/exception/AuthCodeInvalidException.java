package com.data.common.lang.exception;

/**
 * 认证码失效异常
 *
 * @author jidaojiuyou
 */
public class AuthCodeInvalidException extends BaseException {

    /**
     * 无参构造
     */
    public AuthCodeInvalidException() {
        super("认证码已失效");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public AuthCodeInvalidException(String message) {
        super(message);
    }
}