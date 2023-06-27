package com.data.common.lang.exception;

/**
 * 账号或密码错误异常
 *
 * @author jidaojiuyou
 */
public class UsernameOrPasswordErrorException extends BaseException {

    /**
     * 无参构造
     */
    public UsernameOrPasswordErrorException() {
        super("账号或密码错误");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public UsernameOrPasswordErrorException(String message) {
        super(message);
    }
}