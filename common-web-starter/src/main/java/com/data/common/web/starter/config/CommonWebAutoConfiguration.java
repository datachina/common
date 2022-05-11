package com.data.common.web.starter.config;

import com.data.common.web.starter.jackson.JacksonModule;
import com.data.common.web.starter.properties.CommonWebProperties;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
     * 注入JavaTimeModule
     *
     * @return JavaTimeModule
     */
    @Bean
    public JavaTimeModule javaTimeModule() {
        return JacksonModule.getJavaTimeModule();
    }

    /**
     * 构造跨域配置参数
     *
     * @return 跨域配置参数
     */
    private CorsConfiguration corsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }

    /**
     * 使用拦截器后的全局跨域配置
     *
     * @return 跨域拦截器
     */
    @Bean
    @ConditionalOnProperty(prefix = "data.common.default-cors", name = "enable", havingValue = "true")
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig());
        return new CorsFilter(source);
    }
}