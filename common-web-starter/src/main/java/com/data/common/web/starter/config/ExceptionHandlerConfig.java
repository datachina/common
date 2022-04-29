package com.data.common.web.starter.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常拦截配置
 *
 * @author jidaojiuyou
 */
@AllArgsConstructor
@Getter
public class ExceptionHandlerConfig {
    /**
     * 是否打印异常栈
     */
    private Boolean enablePrintStack;
    /**
     * 是否记录日志
     */
    private Boolean enableLog;
}