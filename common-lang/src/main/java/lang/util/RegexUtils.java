package lang.util;

import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

/**
 * 正则工具类
 *
 * @author jidaojiuyou
 */
@SuppressWarnings("unused")
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class RegexUtils {
    /**
     * url 正则表达式
     */
    public static final String URL_REGEX = "(https?|ftp|file)://[-A-Za-z\\d+&@#/%?=~_|!:,.;]+[-A-Za-z\\d+&@#/%=~_|]";
    /**
     * 泛匹配
     */
    public static final String UNIVERSAL_REGEX = "*";

    /**
     * 指定值是否不为null或为空字符串
     *
     * @param str 指定字符串
     * @return 是否不为null或者空字符串
     */
    public static boolean isUrl(String str) {
        if (str == null) {
            return false;
        }
        return str.toLowerCase().matches(URL_REGEX);
    }

    /**
     * 字符串模糊匹配
     *
     * @param pattern 表达式
     * @param str     待匹配的字符串
     * @return 是否可以匹配
     */
    public static boolean fuzzyMatch(String pattern, String str) {
        // 如果表达式不带有*号，则只需简单equals即可 (速度提升200倍)
        if (!pattern.contains(UNIVERSAL_REGEX)) {
            return pattern.equals(str);
        }
        return Pattern.matches(pattern.replaceAll("\\*", ".*"), str);
    }
}