package com.data.common.web.starter.handler.crud;

import com.data.common.lang.exception.UpdateFailedException;
import com.data.common.lang.util.AssertUtils;
import com.data.common.web.response.ResponseCode;
import com.data.common.web.response.ResultEntity;
import com.data.common.web.starter.annotation.ConditionalOnMissingClassName;
import com.data.common.web.starter.config.ExceptionHandlerConfig;
import com.data.common.web.starter.constant.BeanOrdered;
import com.data.common.web.starter.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 更新失败异常拦截器,可以拦截更新失败异常,并处理异常
 *
 * @author jidaojiuyou
 * @see UpdateFailedException
 * @see AssertUtils#updateSuccess
 */
@RestControllerAdvice
@Slf4j
@Order(BeanOrdered.HIGH_PRECEDENCE)
@ConditionalOnMissingClassName(classes = "UpdateFailedExceptionHandler")
public class UpdateFailedExceptionHandler {

    @ExceptionHandler(UpdateFailedException.class)
    public ResultEntity handler(UpdateFailedException e) {
        ExceptionHandlerConfig cfg = SpringUtils.getBean(ExceptionHandlerConfig.class);
        if (cfg.getEnableLog()) {
            log.error("更新失败:{}", e.getMessage());
        }
        if (cfg.getEnablePrintStack()) {
            e.printStackTrace();
        }
        return ResultEntity
                .builder()
                .code(ResponseCode.UPDATE_FAILED.getCode())
                .msg(e.getMessage() != null ? e.getMessage() : ResponseCode.UPDATE_FAILED.getDescription())
                .build();
    }
}