package com.data.common.web.validation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置参数
 *
 * @author jidaojiuyou
 */
@ConfigurationProperties(prefix = "data.common.validation")
@Getter
@Setter
public class ValidationProperties {
    /**
     * 是否打印栈
     */
    private boolean printStackTrace = false;
    /**
     * 是否打印日志
     */
    private boolean printLog = false;
}