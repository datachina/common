package com.data.common.lang.util;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean 工具类
 *
 * @author jidaojiuyou
 */
@SuppressWarnings("unused")
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class BeanUtils {


    /**
     * 检查非排除字段是否全为{@code null}
     *
     * @param o            对象
     * @param excludeField 排除的字段
     * @return 是否全为null
     */
    @SneakyThrows({NoSuchFieldException.class, IllegalAccessException.class})
    public static Boolean isAllFiledNull(@NotNull Object o, @NotNull Collection<String> excludeField) {
        // 反射获取对象的Class
        Class<?> clazz = o.getClass();
        // 获取所有的字段
        Field[] declaredFields = clazz.getDeclaredFields();
        // 处理字段
        List<String> fields = Arrays
                //先将字段转为stream
                .stream(declaredFields)
                // 然后取出Field的name
                .map(Field::getName)
                // 排除序列化版本字段
                .filter(field -> !"serialVersionUID".equals(field))
                // 排除 非静态内部类 的 外部类 引用字段
                .filter(field -> !field.startsWith("this$"))
                // 排除过滤字段
                .filter(field -> excludeField.stream().noneMatch(field::equalsIgnoreCase))
                // 收集结果
                .collect(Collectors.toList());
        // 循环取处理后的字段的值进行判断，是否为null
        for (String field : fields) {
            // 取出一个字段
            Field declaredField = clazz.getDeclaredField(field);
            // 取消 Java 语言访问检查
            declaredField.setAccessible(true);
            // 获取当前字段的值
            Object value = declaredField.get(o);
            // 判断值是否为null
            if (null != value) {
                // 如果字段有值，则非全为null
                return false;
            }
        }
        // 最后，全为null
        return true;
    }
}