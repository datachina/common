package com.data.common.lang.exception;

/**
 * 验证码过期
 *
 * @author jidaojiuyou
 */
public class CaptchaExpireException extends BaseException {

    /**
     * 无参构造
     */
    public CaptchaExpireException() {
        super("验证码已过期");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public CaptchaExpireException(String message) {
        super(message);
    }
}
