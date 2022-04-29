package com.data.common.web.starter.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置
 *
 * @author jidaojiuyou
 */
@ConfigurationProperties(prefix = "data.common")
@Getter
@Setter
public class CommonWebProperties {
    /**
     * 日志配置
     */
    private Log log = new Log();
    /**
     * 异常拦截配置
     */
    private ExceptionHandler exceptionHandler = new ExceptionHandler();

    /**
     * 日志配置
     */
    @Getter
    @Setter
    public static class Log {
        private Boolean enabled = true;
    }

    /**
     * 异常拦截
     */
    @Getter
    @Setter
    public static class ExceptionHandler {
        private Boolean printStackTrace = true;
    }
}