package com.data.common.web.validation.config;

import com.data.common.web.validation.properties.ValidationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 激活配置参数
 *
 * @author jidaojiuyou
 */
@EnableConfigurationProperties(ValidationProperties.class)
@AutoConfiguration
public class ValidationConfiguration {

}