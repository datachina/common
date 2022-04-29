package com.data.common.web.starter.handler.valid;


import com.data.common.web.response.ResponseCode;
import com.data.common.web.response.ResultEntity;
import com.data.common.web.starter.annotation.ConditionalOnMissingClassName;
import com.data.common.web.starter.config.ExceptionHandlerConfig;
import com.data.common.web.starter.constant.BeanOrdered;
import com.data.common.web.starter.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

/**
 * 参数校验异常监听器
 *
 * @author jidaojiuyou
 */
@RestControllerAdvice
@Slf4j
@Order(BeanOrdered.HIGH_PRECEDENCE)
@ConditionalOnClass(ConstraintViolationException.class)
@ConditionalOnMissingClassName(classes = "ValidateExceptionHandler")
public class ValidateExceptionHandler {

    /**
     * {@link BindException} 对"对象"进行参数校验时出现的异常<br>
     *
     * @param e 异常
     * @return 请求参数异常的响应
     * @see BindException
     */
    @ExceptionHandler(BindException.class)
    public ResultEntity handleBindException(BindException e) {
        String errors = e.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
        return getResultEntity(e, errors);
    }

    /**
     * {@link MethodArgumentNotValidException} 对 {@code @RequestBody}进行参数校验时出现的异常<br>
     *
     * @param e 异常
     * @return 请求参数异常的响应
     * @see MethodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errors = e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
        return getResultEntity(e, errors);
    }

    /**
     * {@link ConstraintViolationException} 对具体值进行参数校验时出现的异常 ,也属于 {@link ValidationException}<br>
     *
     * @param e 异常
     * @return 请求参数异常的响应
     * @see ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public ResultEntity handleConstraintViolationException(ConstraintViolationException e) {
        String errors = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
        return getResultEntity(e, errors);
    }

    /**
     * 统一处理
     *
     * @param e      异常
     * @param errors 错误内容
     * @return 封装好的 ResultEntity
     */
    private ResultEntity getResultEntity(Exception e, String errors) {
        ExceptionHandlerConfig cfg = SpringUtils.getBean(ExceptionHandlerConfig.class);
        if (cfg.getEnableLog()) {
            log.error("请求参数异常:{}", errors);
        }
        if (cfg.getEnablePrintStack()) {
            e.printStackTrace();
        }
        return ResultEntity
                .builder()
                .code(ResponseCode.PARAM_CHECK_EXCEPTION.getCode())
                .msg(ResponseCode.PARAM_CHECK_EXCEPTION.getDescription())
                .result(errors)
                .build();
    }
}