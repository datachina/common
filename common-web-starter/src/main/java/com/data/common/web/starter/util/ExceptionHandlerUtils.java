package com.data.common.web.starter.util;

import com.data.common.web.starter.properties.CommonWebProperties;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;

/**
 * 异常拦截器工具类
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ExceptionHandlerUtils {


    /**
     * 异常拦截预处理，记录日志，抛异常
     *
     * @param cfg             用户配置
     * @param e               异常
     * @param preMsg          日志前置说明
     * @param msg             日志消息
     * @param printLog        是否记录日志
     * @param printStackTrace 是否打印异常栈
     * @param log             记录日志的对象 {@link Logger}
     */
    public static void preHandle(CommonWebProperties cfg, Exception e, String preMsg, String msg, Boolean printLog, Boolean printStackTrace, Logger log) {
        Boolean globalPrintStackTrace = cfg.getExceptionHandler().getGlobal().getPrintStackTrace();
        Boolean globalPrintLog = cfg.getExceptionHandler().getGlobal().getPrintLog();

        // 本拦截器配置不为空且允许记录日志
        if ((printLog != null && printLog)) {
            log.error("{}:{}", preMsg, msg);
        }

        // 本拦截器配置为空且全局允许记录日志
        if (printLog == null && globalPrintLog) {
            log.error("{}:{}", preMsg, msg);
        }

        // 本拦截器配置不为空且允许打印异常栈
        if (printStackTrace != null && printStackTrace) {
            e.printStackTrace();
        }

        // 本拦截器配置为空且全局允许打印异常栈
        if (printStackTrace == null && globalPrintStackTrace) {
            e.printStackTrace();
        }
    }
}