package com.data.common.web.starter.config;

import com.data.common.web.starter.jackson.JacksonModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动包扫描
 *
 * @author jidaojiuyou
 */
@ComponentScan("com.data.common")
@Configuration
public class CommonWebAutoConfiguration {

    /**
     * 注入JavaTimeModule
     *
     * @return JavaTimeModule
     */
    @Bean
    public JavaTimeModule javaTimeModule() {
        return JacksonModule.getJavaTimeModule();
    }
}