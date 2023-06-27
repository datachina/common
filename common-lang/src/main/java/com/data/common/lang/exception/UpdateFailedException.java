package com.data.common.lang.exception;

/**
 * 修改失败异常
 *
 * @author jidaojiuyou
 */
public class UpdateFailedException extends BaseException {

    /**
     * 无参构造
     */
    public UpdateFailedException() {
        super("更新失败");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public UpdateFailedException(String message) {
        super(message);
    }
}