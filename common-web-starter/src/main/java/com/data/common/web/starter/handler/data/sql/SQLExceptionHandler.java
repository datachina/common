package com.data.common.web.starter.handler.data.sql;

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

import java.sql.SQLException;

/**
 * SQL异常拦截器
 *
 * @author jidaojiuyou
 */
@RestControllerAdvice
@Slf4j
@Order(BeanOrdered.HIGH_PRECEDENCE)
@ConditionalOnProperty(prefix = "data.common.exception-handler.sql", name = "enable", havingValue = "true")
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class SQLExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public ResultEntity handler(SQLException e) {
        CommonWebProperties cfg = SpringUtils.getBean(CommonWebProperties.class);
        String msg = e.getMessage() != null ? e.getMessage() : ResponseCode.DATABASE_EXCEPTION.getDescription();
        Boolean printStackTrace = cfg.getExceptionHandler().getSql().getPrintStackTrace();
        Boolean printLog = cfg.getExceptionHandler().getSql().getPrintLog();
        ExceptionHandlerUtils.preHandle(cfg, e, "数据库异常", msg, printLog, printStackTrace, log);
        return ResultEntity
                .builder()
                .code(ResponseCode.DATABASE_EXCEPTION.getCode())
                .msg(msg)
                .build();
    }
}