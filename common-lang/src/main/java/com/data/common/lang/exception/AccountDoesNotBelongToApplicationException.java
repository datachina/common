package com.data.common.lang.exception;

/**
 * 账号不属于本应用
 *
 * @author jidaojiuyou
 */
public class AccountDoesNotBelongToApplicationException extends BaseException {

    /**
     * 无参构造
     */
    public AccountDoesNotBelongToApplicationException() {
        super("当前账号不属于本应用");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public AccountDoesNotBelongToApplicationException(String message) {
        super(message);
    }
}