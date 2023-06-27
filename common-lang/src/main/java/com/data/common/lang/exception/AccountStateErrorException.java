package com.data.common.lang.exception;

/**
 * 账号状态异常
 *
 * @author jidaojiuyou
 */
public class AccountStateErrorException extends BaseException {

    /**
     * 无参构造
     */
    public AccountStateErrorException() {
        super("账号状态错误");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public AccountStateErrorException(String message) {
        super(message);
    }
}