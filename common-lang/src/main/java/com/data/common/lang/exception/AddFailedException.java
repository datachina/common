package com.data.common.lang.exception;

/**
 * 新增失败异常
 *
 * @author jidaojiuyou
 */
public class AddFailedException extends BaseException {

    /**
     * 无参构造
     */
    public AddFailedException() {
        super("新增失败");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public AddFailedException(String message) {
        super(message);
    }
}