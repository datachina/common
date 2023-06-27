package com.data.common.lang.exception;

/**
 * 查询失败异常
 *
 * @author jidaojiuyou
 */
public class QueryFailedException extends BaseException {

    /**
     * 无参构造
     */
    public QueryFailedException() {
        super("查询失败");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public QueryFailedException(String message) {
        super(message);
    }
}