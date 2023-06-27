package com.data.common.lang.exception;

/**
 * 账号不存在异常，一般用于登陆
 *
 * @author jidaojiuyou
 */
public class AccountDoesNotExistsException extends BaseException {

    /**
     * 无参构造
     */
    public AccountDoesNotExistsException() {
        super("账号不存在");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public AccountDoesNotExistsException(String message) {
        super(message);
    }
}