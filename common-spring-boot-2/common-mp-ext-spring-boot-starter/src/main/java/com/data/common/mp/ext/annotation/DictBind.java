package com.data.common.mp.ext.annotation;

import java.lang.annotation.*;

/**
 * 字典值绑定注解
 *
 * @author jidaojiuyou
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DictBind {

    /**
     * 获取字典值的策略
     *
     * @return 策略
     */
    String strategy() default "";

    /**
     * 字典id
     *
     * @return 字典id
     */
    String dictId() default "";

    /**
     * 目标映射字段
     *
     * @return 映射字段
     */
    String targetField() default "";
}