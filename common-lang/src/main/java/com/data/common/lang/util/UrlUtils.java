package com.data.common.lang.util;

import lombok.NoArgsConstructor;

/**
 * Url 工具类
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class UrlUtils {

    /**
     * 在url上拼接上kv参数
     *
     * @param url   url
     * @param key   参数名称
     * @param value 参数值
     * @return 拼接后的url字符串
     */
    public static String joinParam(String url, String key, Object value) {
        // 如果参数为空, 直接返回
        if (StringUtils.isEmpty(url) || StringUtils.isEmpty(key) || value == null || "".equals(value)) {
            return url;
        }
        return joinParam(url, key + "=" + value);
    }


    /**
     * 在url上拼接上kv参数
     *
     * @param url      url
     * @param paramStr 参数, 例如 id=1001
     * @return 拼接后的url字符串
     */
    public static String joinParam(String url, String paramStr) {
        // 如果参数为空, 直接返回
        if (paramStr == null || paramStr.length() == 0) {
            return url;
        }
        if (url == null) {
            url = "";
        }
        int index = url.lastIndexOf('?');
        // ? 不存在
        if (index == -1) {
            return url + '?' + paramStr;
        }
        // ? 是最后一位
        if (index == url.length() - 1) {
            return url + paramStr;
        }
        // ? 是其中一位
        if (index < url.length() - 1) {
            String separatorChar = "&";
            // 如果&不在最后一位，也不在第一位。则添加一个 &
            if (url.lastIndexOf(separatorChar) != url.length() - 1 && paramStr.indexOf(separatorChar) != 0) {
                return url + separatorChar + paramStr;
            } else {
                return url + paramStr;
            }
        }
        return url;
    }
}