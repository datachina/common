package com.data.common.web.starter.handler.crud;

import com.data.common.lang.exception.AddFailedException;
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
 * 新增失败异常拦截器,可以拦截新增失败异常,并处理异常
 *
 * @author jidaojiuyou
 * @see AddFailedException
 * @see AssertUtils#addSuccess
 */
@RestControllerAdvice
@Slf4j
@Order(BeanOrdered.HIGH_PRECEDENCE)
@ConditionalOnProperty(prefix = "data.common.exception-handler.add", name = "enable", havingValue = "true")
public class AddFailedExceptionHandler {

    @ExceptionHandler(AddFailedException.class)
    public ResultEntity handler(AddFailedException e) {
        CommonWebProperties cfg = SpringUtils.getBean(CommonWebProperties.class);
        String msg = e.getMessage() != null ? e.getMessage() : ResponseCode.ADD_FAILED.getDescription();
        Boolean printStackTrace = cfg.getExceptionHandler().getAdd().getPrintStackTrace();
        Boolean printLog = cfg.getExceptionHandler().getAdd().getPrintLog();
        ExceptionHandlerUtils.preHandle(cfg, e, "新增失败", msg, printLog, printStackTrace, log);
        return ResultEntity
                .builder()
                .code(ResponseCode.ADD_FAILED.getCode())
                .msg(msg)
                .build();
    }
}