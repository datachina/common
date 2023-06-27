package com.data.common.lang.util;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class StringUtils {
    /**
     * 指定值是否为null或为空字符串
     *
     * @param str 指定字符串
     * @return 是否为null或者空字符串
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 指定值是否不为null或为空字符串
     *
     * @param str 指定字符串
     * @return 是否不为null或者空字符串
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 将指定字符串按照逗号分隔符转化为字符串集合
     *
     * @param str 字符串
     * @return 分割后的字符串集合
     */
    public static List<String> convertStringToList(String str) {
        List<String> list = new ArrayList<>();
        // str为空则返回空list
        if (isEmpty(str)) {
            return list;
        }
        // 不为空则转为数组
        String[] arr = str.split(",");
        // 遍历放入list
        for (String s : arr) {
            // 去掉首尾空格
            s = s.trim();
            // 如果不为空则存入list
            if (isNotEmpty(s)) {
                list.add(s);
            }
        }
        // 返回list
        return list;
    }

    /**
     * 将字符串首字母改为大写/小写
     *
     * @param str     str
     * @param isUpper 转成大写字母/小写字母
     * @return 转换后的字符串
     */
    public static String switchFirstLetter(String str, Boolean isUpper) {
        if (isUpperLetter(str.charAt(0)) && !isUpper) {
            char[] chars = str.toCharArray();
            chars[0] += 32;
            return String.valueOf(chars);
        } else if (isLowerLetter(str.charAt(0)) && isUpper) {
            char[] chars = str.toCharArray();
            chars[0] -= 32;
            return String.valueOf(chars);
        }
        return str;
    }

    /**
     * 判断是否为大写字母
     *
     * @param c 字符
     * @return 是否为大写字母
     */
    public static Boolean isUpperLetter(Character c) {
        return Character.isUpperCase(c);
    }

    /**
     * 判断是否为小写字母
     *
     * @param c 字符
     * @return 是否为小写字母
     */
    public static Boolean isLowerLetter(Character c) {
        return Character.isLowerCase(c);
    }

    /**
     * 判断是否为字母
     *
     * @param c 字符
     * @return 是否为字母
     */
    public static Boolean isLetter(Character c) {
        return Character.isLetter(c);
    }
}