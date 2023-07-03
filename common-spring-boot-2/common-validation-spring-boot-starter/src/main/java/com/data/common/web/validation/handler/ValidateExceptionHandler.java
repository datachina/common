package com.data.common.web.validation.handler;


import com.data.common.web.response.ResponseCode;
import com.data.common.web.response.ResultEntity;
import com.data.common.web.validation.properties.ValidationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
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
@Order(Integer.MIN_VALUE)
@ConditionalOnClass(ConstraintViolationException.class)
public class ValidateExceptionHandler {

    /**
     * 配置参数
     */
    @Resource
    private ValidationProperties properties;

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
        if (properties.isPrintLog()) {
            log.error("参数校验异常:{}", errors);
        }
        if (properties.isPrintStackTrace()) {
            e.printStackTrace();
        }
        return ResultEntity
                .builder()
                .code(ResponseCode.PARAM_CHECK_EXCEPTION.getCode())
                .msg(errors)
                .build();
    }
}