package com.data.common.lang.exception;

/**
 * 不支持的请求
 *
 * @author jidaojiuyou
 */
public class UnsupportedRequestException extends BaseException {

    /**
     * 无参构造
     */
    public UnsupportedRequestException() {
        super("不支持的请求");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public UnsupportedRequestException(String message) {
        super(message);
    }
}