package com.data.common.lang.exception;

import lombok.NoArgsConstructor;

/**
 * 修改失败异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class UpdateFailedException extends BaseException {

    /**
     * @param message 异常消息
     */
    public UpdateFailedException(String message) {
        super(message);
    }
}