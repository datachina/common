package com.data.common.lang.exception;

/**
 * 删除失败异常
 *
 * @author jidaojiuyou
 */
public class DeleteFailedException extends BaseException {

    /**
     * 无参构造
     */
    public DeleteFailedException() {
        super("删除失败");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public DeleteFailedException(String message) {
        super(message);
    }
}