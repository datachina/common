package com.data.common.web.starter.annotation;

import com.data.common.web.starter.startup.AppStartUpInfo;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用自动打印系统访问信息
 *
 * @author jidaojiuyou
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(AppStartUpInfo.class)
public @interface EnableAppStartUpInfo {

}