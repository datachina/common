package com.data.common.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应实体
 *
 * @author jidaojiuyou
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultEntity {
    /**
     * 响应码
     */
    @Builder.Default
    private String code = ResponseCode.SUCCESS.getCode();
    /**
     * 响应消息
     */
    @Builder.Default
    private String msg = ResponseCode.SUCCESS.getDescription();
    /**
     * 响应内容
     */
    private Object result;

    /**
     * 快速成功
     *
     * @return 成功
     */
    public static ResultEntity success() {
        return new ResultEntity();
    }

    /**
     * 快速成功
     *
     * @param result 结果
     * @return 成功
     */
    public static ResultEntity success(Object result) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setResult(result);
        return resultEntity;
    }

    /**
     * 快速失败
     *
     * @return 失败
     */
    public static ResultEntity failure() {
        return ResultEntity
                .builder()
                .code(ResponseCode.FAILURE.getCode())
                .msg(ResponseCode.FAILURE.getDescription())
                .build();
    }

    /**
     * 快速失败
     *
     * @param result 结果
     * @return 失败
     */
    public static ResultEntity failure(Object result) {
        return ResultEntity
                .builder()
                .code(ResponseCode.FAILURE.getCode())
                .msg(ResponseCode.FAILURE.getDescription())
                .result(result)
                .build();
    }

    /**
     * 快速失败
     *
     * @param msg 消息
     * @return 失败
     */
    public static ResultEntity failure(String msg) {
        return ResultEntity
                .builder()
                .code(ResponseCode.FAILURE.getCode())
                .msg(msg)
                .build();
    }
}