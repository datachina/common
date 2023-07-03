package com.data.common.web.starter.annotation;

import com.data.common.web.response.ResultEntity;

import java.lang.annotation.*;

/**
 * 响应包装,加了该注解的类或接口返回值会自动被包装成{@link ResultEntity}<br>
 * 类加了该注解会默认包装该类的所有接口。<br>
 * pack 字段用于限定是否包装返回值
 *
 * @author jidaojiuyou
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ResponsePack {
    /**
     * 是否需要包装
     *
     * @return 是否需要包装
     */
    boolean pack() default true;
}