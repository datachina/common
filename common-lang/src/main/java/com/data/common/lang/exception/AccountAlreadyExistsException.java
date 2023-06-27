package com.data.common.lang.exception;

/**
 * 账号已存在异常，一般用于注册
 *
 * @author jidaojiuyou
 */
public class AccountAlreadyExistsException extends BaseException {

    /**
     * 无参构造
     */
    public AccountAlreadyExistsException() {
        super("账号已存在");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}