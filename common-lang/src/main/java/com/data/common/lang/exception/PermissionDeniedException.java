package com.data.common.lang.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 没有权限异常
 *
 * @author jidaojiuyou
 */
@Getter
public class PermissionDeniedException extends BaseException {

    /**
     * 需要的权限
     */
    private final List<String> needPermissionList;

    /**
     * 无参构造
     */
    public PermissionDeniedException() {
        super("没有权限");
        this.needPermissionList = new ArrayList<>();
    }

    /**
     * 未授权列表构造
     *
     * @param needPermissionList 需要的权限列表
     */
    public PermissionDeniedException(List<String> needPermissionList) {
        super("没有权限");
        this.needPermissionList = needPermissionList;
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public PermissionDeniedException(String message) {
        super(message);
        this.needPermissionList = new ArrayList<>();
    }

    /**
     * 错误消息和未授权列表构造
     *
     * @param message            错误消息
     * @param needPermissionList 需要的权限列表
     */
    public PermissionDeniedException(String message, List<String> needPermissionList) {
        super(message);
        this.needPermissionList = needPermissionList;
    }
}