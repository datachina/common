package com.data.common.lang.exception;

import lombok.NoArgsConstructor;

/**
 * 文件上传失败异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class FileUploadFailException extends BaseException {

    /**
     * @param message 异常消息
     */
    public FileUploadFailException(String message) {
        super(message);
    }
}