package com.data.common.lang.exception;

/**
 * 文件上传失败异常
 *
 * @author jidaojiuyou
 */
public class FileUploadFailException extends BaseException {

    /**
     * 无参构造
     */
    public FileUploadFailException() {
        super("文件上传失败");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public FileUploadFailException(String message) {
        super(message);
    }
}