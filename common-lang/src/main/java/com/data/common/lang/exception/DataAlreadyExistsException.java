package com.data.common.lang.exception;

/**
 * 数据已存在
 *
 * @author jidaojiuyou
 */
public class DataAlreadyExistsException extends BaseException {

    /**
     * 无参构造
     */
    public DataAlreadyExistsException() {
        super("数据已存在");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public DataAlreadyExistsException(String message) {
        super(message);
    }
}