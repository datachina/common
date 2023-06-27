package com.data.common.lang.exception;

/**
 * 数据不存在
 *
 * @author jidaojiuyou
 */
public class DataDoesNotExistsException extends BaseException {

    /**
     * 无参构造
     */
    public DataDoesNotExistsException() {
        super("数据不存在");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public DataDoesNotExistsException(String message) {
        super(message);
    }
}