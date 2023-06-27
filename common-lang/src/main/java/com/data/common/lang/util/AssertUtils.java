package com.data.common.lang.util;

import com.data.common.lang.exception.AddFailedException;
import com.data.common.lang.exception.DeleteFailedException;
import com.data.common.lang.exception.QueryFailedException;
import com.data.common.lang.exception.UpdateFailedException;
import lombok.NoArgsConstructor;

/**
 * 断言工具类
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class AssertUtils {

    /**
     * 检查新增是否成功,失败抛出异常
     *
     * @param isSuccess 是否成功
     * @see AddFailedException
     */
    public static void addSuccess(boolean isSuccess) {
        if (!isSuccess) {
            throw new AddFailedException();
        }
    }

    /**
     * 检查新增是否成功,失败抛出异常
     *
     * @param isSuccess 是否成功
     * @param message   失败时需要返回的消息
     * @see AddFailedException
     */
    public static void addSuccess(boolean isSuccess, String message) {
        if (!isSuccess) {
            throw new AddFailedException(message);
        }
    }

    /**
     * 检查删除是否成功,失败抛出异常
     *
     * @param isSuccess 是否成功
     * @see DeleteFailedException
     */
    public static void deleteSuccess(boolean isSuccess) {
        if (!isSuccess) {
            throw new DeleteFailedException();
        }
    }

    /**
     * 检查删除是否成功,失败抛出异常
     *
     * @param isSuccess 是否成功
     * @param message   失败时需要返回的消息
     * @see DeleteFailedException
     */
    public static void deleteSuccess(boolean isSuccess, String message) {
        if (!isSuccess) {
            throw new DeleteFailedException(message);
        }
    }

    /**
     * 检查修改是否成功,失败抛出异常
     *
     * @param isSuccess 是否成功
     * @see UpdateFailedException
     */
    public static void updateSuccess(boolean isSuccess) {
        if (!isSuccess) {
            throw new UpdateFailedException();
        }
    }

    /**
     * 检查修改是否成功,失败抛出异常
     *
     * @param isSuccess 是否成功
     * @param message   失败时需要返回的消息
     * @see UpdateFailedException
     */
    public static void updateSuccess(boolean isSuccess, String message) {
        if (!isSuccess) {
            throw new UpdateFailedException(message);
        }
    }

    /**
     * 检查查询是否成功,失败抛出异常
     *
     * @param isSuccess 是否成功
     * @see QueryFailedException
     */
    public static void querySuccess(boolean isSuccess) {
        if (!isSuccess) {
            throw new QueryFailedException();
        }
    }

    /**
     * 检查查询是否成功,失败抛出异常
     *
     * @param isSuccess 是否成功
     * @param message   失败时需要返回的消息
     * @see QueryFailedException
     */
    public static void querySuccess(boolean isSuccess, String message) {
        if (!isSuccess) {
            throw new QueryFailedException(message);
        }
    }
}