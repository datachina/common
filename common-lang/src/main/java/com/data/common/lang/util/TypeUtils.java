package com.data.common.lang.util;

import lombok.NoArgsConstructor;

/**
 * 类型判断工具类
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class TypeUtils {

    /**
     * 是否为 {@link byte} 或 {@link Byte}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isByte(Object o) {
        return o instanceof Byte;
    }

    /**
     * 是否为 {@link short} 或 {@link Short}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isShort(Object o) {
        return o instanceof Short;
    }

    /**
     * 是否为 {@link int} 或 {@link Integer}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isInteger(Object o) {
        return o instanceof Integer;
    }

    /**
     * 是否为 {@link long} 或 {@link Long}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isLong(Object o) {
        return o instanceof Long;
    }

    /**
     * 是否为 {@link float} 或 {@link Float}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isFloat(Object o) {
        return o instanceof Float;
    }

    /**
     * 是否为 {@link double} 或 {@link Double}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isDouble(Object o) {
        return o instanceof Double;
    }

    /**
     * 是否为 {@link char} 或 {@link Character}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isCharacter(Object o) {
        return o instanceof Character;
    }

    /**
     * 是否为 {@link boolean} 或 {@link Boolean}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isBoolean(Object o) {
        return o instanceof Boolean;
    }


    /**
     * 是否为 {@code null}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isNull(Object o) {
        return null == o;
    }

    /**
     * 是否为 {@link Number}
     *
     * @param o 被判断的值
     * @return 判断结果
     */
    public static Boolean isNumber(Object o) {
        return o instanceof Number;
    }
}