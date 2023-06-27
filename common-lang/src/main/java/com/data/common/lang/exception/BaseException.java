package com.data.common.lang.exception;

import lombok.Getter;

/**
 * 公共异常类
 *
 * @author jidaojiuyou
 */
@Getter
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    /**
     * 无参构造
     */
    public BaseException() {
        super();
        // 默认错误码为0
        this.code = 0;
    }

    /**
     * 错误码构造
     *
     * @param code 错误码
     */
    public BaseException(int code) {
        super();
        this.code = code;
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public BaseException(String message) {
        super(message);
        this.code = 0;
    }

    /**
     * 错误消息和错误码构造
     *
     * @param message 异常消息
     * @param code    错误码
     */
    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }
}