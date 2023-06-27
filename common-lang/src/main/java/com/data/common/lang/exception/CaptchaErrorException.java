package com.data.common.lang.exception;

/**
 * 验证码错误
 *
 * @author jidaojiuyou
 */
public class CaptchaErrorException extends BaseException {

    /**
     * 无参构造
     */
    public CaptchaErrorException() {
        super("验证码错误");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public CaptchaErrorException(String message) {
        super(message);
    }
}
