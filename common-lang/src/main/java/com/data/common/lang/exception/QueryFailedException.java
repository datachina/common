package com.data.common.lang.exception;

import lombok.NoArgsConstructor;

/**
 * 查询失败异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class QueryFailedException extends BaseException {

    /**
     * @param message 异常消息
     */
    public QueryFailedException(String message) {
        super(message);
    }
}