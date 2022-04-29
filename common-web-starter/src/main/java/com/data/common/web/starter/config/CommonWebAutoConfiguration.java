package com.data.common.web.starter.config;

import com.data.common.web.starter.jackson.JacksonModule;
import com.data.common.web.starter.properties.CommonWebProperties;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 自动包扫描
 *
 * @author jidaojiuyou
 */
@ComponentScan("com.data.common")
@Configuration
@EnableConfigurationProperties(CommonWebProperties.class)
public class CommonWebAutoConfiguration {

    /**
     * 注入自定义配置参数
     */
    @Resource
    private CommonWebProperties properties;

    /**
     * 注入JavaTimeModule
     *
     * @return JavaTimeModule
     */
    @Bean
    public JavaTimeModule javaTimeModule() {
        return JacksonModule.getJavaTimeModule();
    }

    /**
     * 注入ExceptionHandlerConfig
     *
     * @return ExceptionHandlerConfig
     */
    @Bean
    public ExceptionHandlerConfig exceptionHandlerConfig() {
        return new ExceptionHandlerConfig(properties.getExceptionHandler().getPrintStackTrace(), properties.getLog().getEnabled());
    }
}