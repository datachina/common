package com.data.common.lang.exception;

/**
 * 自动映射未找到
 *
 * @author jidaojiuyou
 */
public class AutoMappingNotFoundException extends BaseException {

    /**
     * 无参构造
     */
    public AutoMappingNotFoundException() {
        super("自动映射策略未找到");
    }

    /**
     * 错误消息构造
     *
     * @param message 错误消息
     */
    public AutoMappingNotFoundException(String message) {
        super(message);
    }

    public AutoMappingNotFoundException(Class<?> srcClass, Class<?> destClass) {
        super("未找到 " + srcClass.getName() + " 到 " + destClass.getName() + "的转换策略。 请检查 @AutoMappingClass 是否标注在 " + srcClass.getName() + " 或 " + destClass.getName() + "上。");
    }
}