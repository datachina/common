package com.data.common.lang.exception;

/**
 * 参数为空异常
 *
 * @author jidaojiuyou
 */
public class ParamEmptyException extends BaseException {

    /**
     * 无参构造
     */
    public ParamEmptyException() {
        super("参数不能为空");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public ParamEmptyException(String message) {
        super(message);
    }
}