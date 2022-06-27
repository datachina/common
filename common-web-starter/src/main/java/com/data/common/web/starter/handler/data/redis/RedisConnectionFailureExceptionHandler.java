package com.data.common.web.starter.handler.data.redis;

import com.data.common.web.response.ResponseCode;
import com.data.common.web.response.ResultEntity;
import com.data.common.web.starter.constant.BeanOrdered;
import com.data.common.web.starter.properties.CommonWebProperties;
import com.data.common.web.starter.util.ExceptionHandlerUtils;
import com.data.common.web.starter.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Redis连接失败异常拦截器
 *
 * @author jidaojiuyou
 */
@RestControllerAdvice
@Slf4j
@Order(BeanOrdered.HIGH_PRECEDENCE)
@ConditionalOnClass(RedisConnectionFailureException.class)
@ConditionalOnProperty(prefix = "data.common.exception-handler.redis-connect-failure", name = "enable", havingValue = "true")
public class RedisConnectionFailureExceptionHandler {

    @ExceptionHandler(RedisConnectionFailureException.class)
    public ResultEntity handler(RedisConnectionFailureException e) {
        CommonWebProperties cfg = SpringUtils.getBean(CommonWebProperties.class);
        String msg = e.getMessage() != null ? e.getMessage() : ResponseCode.ADD_FAILED.getDescription();
        Boolean printStackTrace = cfg.getExceptionHandler().getRedisConnectFailure().getPrintStackTrace();
        Boolean printLog = cfg.getExceptionHandler().getRedisConnectFailure().getPrintLog();
        ExceptionHandlerUtils.preHandle(cfg, e, "Redis连接异常", msg, printLog, printStackTrace, log);
        return ResultEntity
                .builder()
                .code(ResponseCode.REDIS_CONNECT_FAILED.getCode())
                .msg(msg)
                .build();
    }
}