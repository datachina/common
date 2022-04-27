package com.data.common.web.util;

import com.data.common.lang.exception.FileUploadFailException;
import com.data.common.lang.exception.PermissionDeniedException;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件处理工具类
 *
 * @author jidaojiuyou
 */
@SuppressWarnings("unused")
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class FileUtils {
    /**
     * 上传文件
     *
     * @param file     文件
     * @param filePath 文件路径
     * @param fileName 文件名
     * @throws IOException IO异常
     */
    public static void uploadFile(MultipartFile file, String filePath, String fileName) throws IOException {
        // 判断文件是否为空
        if (file.isEmpty()) {
            throw new FileUploadFailException("文件上传失败,请重新上传");
        }
        // 创建一个文件路径
        File targetFile = new File(filePath);
        // 判断目录是否存在
        if (targetFile.exists() || targetFile.mkdir()) {
            File dest = new File(filePath + fileName);
            file.transferTo(dest);
        } else {
            throw new PermissionDeniedException("目录没有权限");
        }
    }

    /**
     * 返回文件的后缀
     *
     * @param filename 文件名
     * @return 后缀
     */
    public static String getExt(String filename) {
        if (filename == null) {
            return null;
        }
        return filename.substring(filename.lastIndexOf("."));
    }
}