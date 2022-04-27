package com.data.common.lang.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 公共异常类
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@Getter
@Setter
@Builder
@SuppressWarnings("unused")
public class BaseException extends RuntimeException {

    private String code;

    /**
     * @param message 异常消息
     */
    public BaseException(String message) {
        super(message);
    }

    /**
     * @param code    错误码
     * @param message 错误消息
     */
    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }
}