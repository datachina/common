package com.data.common.web.starter.handler.crud;

import com.data.common.lang.exception.QueryFailedException;
import com.data.common.lang.util.AssertUtils;
import com.data.common.web.response.ResponseCode;
import com.data.common.web.response.ResultEntity;
import com.data.common.web.starter.constant.BeanOrdered;
import com.data.common.web.starter.properties.CommonWebProperties;
import com.data.common.web.starter.util.ExceptionHandlerUtils;
import com.data.common.web.starter.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 查询失败异常拦截器,可以拦截查询失败异常,并处理异常
 *
 * @author jidaojiuyou
 * @see QueryFailedException
 * @see AssertUtils#querySuccess
 */
@RestControllerAdvice
@Slf4j
@Order(BeanOrdered.HIGH_PRECEDENCE)
@ConditionalOnProperty(prefix = "data.common.exception-handler.query", name = "enable", havingValue = "true")
public class QueryFailedExceptionHandler {

    @ExceptionHandler(QueryFailedException.class)
    public ResultEntity handler(QueryFailedException e) {
        CommonWebProperties cfg = SpringUtils.getBean(CommonWebProperties.class);
        String msg = e.getMessage() != null ? e.getMessage() : ResponseCode.QUERY_FAILED.getDescription();
        Boolean printStackTrace = cfg.getExceptionHandler().getQuery().getPrintStackTrace();
        Boolean printLog = cfg.getExceptionHandler().getQuery().getPrintLog();
        ExceptionHandlerUtils.preHandle(cfg, e, "查询失败", msg, printLog, printStackTrace, log);
        return ResultEntity
                .builder()
                .code(ResponseCode.QUERY_FAILED.getCode())
                .msg(msg)
                .build();
    }
}