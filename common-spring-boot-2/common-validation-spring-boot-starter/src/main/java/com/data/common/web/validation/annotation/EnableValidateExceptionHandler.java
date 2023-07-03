package com.data.common.web.validation.annotation;

import com.data.common.web.validation.handler.ValidateExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用参数校验异常拦截
 *
 * @author jidaojiuyou
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(ValidateExceptionHandler.class)
public @interface EnableValidateExceptionHandler {

}