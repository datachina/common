package com.data.common.web.starter.response;

import com.data.common.web.response.ResultEntity;
import com.data.common.web.starter.annotation.ResponsePack;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 统一后端返回
 *
 * @author jidaojiuyou
 */
@RestControllerAdvice
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice<Object> {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        // 方法是否包含指定注解
        ResponsePack methodAnnotation = returnType.getMethodAnnotation(ResponsePack.class);
        // 类是否包含指定注解
        ResponsePack classAnnotation = returnType.getDeclaringClass().getAnnotation(ResponsePack.class);
        // 方法注解不为空且需要包装
        if (methodAnnotation != null) {
            return methodAnnotation.pack();
        }
        // 否则判断类注解是否不为空且需要包装
        return classAnnotation != null && classAnnotation.pack();
    }

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType, @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NotNull ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().set("Content-Type", "application/json; charset=UTF-8");
        // 如果body为空则返回成功
        if (null == body) {
            // 返回类型需要特殊处理
            if (String.class.equals(returnType.getParameterType())) {
                return objectMapper.writeValueAsString(ResultEntity.success());
            } else {
                return ResultEntity.success();
            }
        }

        // 如果返回String则包装后返回
        if (body instanceof String) {
            return objectMapper.writeValueAsString(ResultEntity.success(body));
        }

        // 如果响应为 Boolean,根据响应值确定返回值
        if (body instanceof Boolean result) {
            if (result) {
                return ResultEntity.success();
            } else {
                return ResultEntity.failure();
            }
        }

        // 有可能直接返回封装好的数据
        if (body instanceof ResultEntity) {
            return body;
        }

        // 返回结果
        return ResultEntity.success(body);
    }
}