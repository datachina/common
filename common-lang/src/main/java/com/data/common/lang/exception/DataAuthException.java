package com.data.common.lang.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 授权异常
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor
@Getter
@Setter
@SuppressWarnings("unused")
@Builder
public class DataAuthException extends BaseException {

    /**
     * 异常类型,异常拦截时方便确定具体异常
     */
    private int type;

    /**
     * 权限列表，一般是scope未签约或需要授权时才会使用
     */
    private List<String> permissionList;

    /**
     * @param type 异常类型
     */
    public DataAuthException(int type) {
        this.type = type;
    }

    /**
     * @param message 异常消息
     */
    public DataAuthException(String message) {
        super(message);
    }

    /**
     * @param permissionList 未授权或未签约的权限列表
     */
    public DataAuthException(List<String> permissionList) {
        this.permissionList = permissionList;
    }

    /**
     * @param type    异常类型
     * @param message 异常消息
     */
    public DataAuthException(int type, String message) {
        super(message);
        this.type = type;
    }

    /**
     * @param type           异常类型
     * @param permissionList 未授权或未签约的权限列表
     */
    public DataAuthException(int type, List<String> permissionList) {
        this.type = type;
        this.permissionList = permissionList;
    }

    /**
     * @param type           异常类型
     * @param message        异常消息
     * @param permissionList 未授权或未签约的权限列表
     */
    public DataAuthException(int type, String message, List<String> permissionList) {
        super(message);
        this.type = type;
        this.permissionList = permissionList;
    }
}