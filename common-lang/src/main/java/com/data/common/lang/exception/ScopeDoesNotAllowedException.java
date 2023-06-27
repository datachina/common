package com.data.common.lang.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * scope 未授权异常
 *
 * @author jidaojiuyou
 */
@Getter
public class ScopeDoesNotAllowedException extends BaseException {

    /**
     * 未授权的scope
     */
    private final List<String> scope;

    /**
     * 无参构造
     */
    public ScopeDoesNotAllowedException() {
        super("scope 未授权");
        this.scope = new ArrayList<>();
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public ScopeDoesNotAllowedException(String message) {
        super(message);
        this.scope = new ArrayList<>();
    }

    /**
     * scope构造
     */
    public ScopeDoesNotAllowedException(List<String> scope) {
        this.scope = scope;
    }

    /**
     * 错误消息和scope构造
     *
     * @param message 错误消息
     * @param scope   scope
     */
    public ScopeDoesNotAllowedException(String message, List<String> scope) {
        super(message);
        this.scope = scope;
    }
}