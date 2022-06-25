package com.data.common.web.starter.annotation;

import com.data.common.web.starter.condition.OnMissingClassNameCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 判断是否有指定名称的类
 *
 * @author jidaojiuyou
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnMissingClassNameCondition.class)
public @interface ConditionalOnMissingClassName {
    /**
     * 要检查的类的类名
     *
     * @return 类名
     */
    String classes() default "";

    /**
     * 值映射到classes
     *
     * @return 类名
     */
    @AliasFor("classes")
    String value() default "";
}