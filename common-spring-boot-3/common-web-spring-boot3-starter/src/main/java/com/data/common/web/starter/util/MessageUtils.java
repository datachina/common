package com.data.common.web.starter.util;

import jakarta.annotation.Resource;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * 国际化消息资源工具
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class MessageUtils {

    @Resource
    private MessageSource messageSource;

    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return 获取国际化翻译值
     */
    public String message(String code, Object... args) {
        try {
            return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            return code;
        }
    }
}