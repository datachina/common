package com.data.common.lang.util;

import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * UUID 工具类
 *
 * @author jidaojiuyou
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class UUIDUtils {

    /**
     * 简单生成 uuid
     *
     * @return uuid
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 选择性的生成 uuid
     *
     * @param haveLine 有没有短线
     * @return uuid
     */
    public static String uuid(Boolean haveLine) {
        if (haveLine) {
            return UUID.randomUUID().toString();
        } else {
            return UUID.randomUUID().toString().replace("-", "");
        }
    }
}