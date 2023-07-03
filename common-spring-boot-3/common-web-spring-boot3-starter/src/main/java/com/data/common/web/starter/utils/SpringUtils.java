package com.data.common.web.starter.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring工具类
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@Getter
@Component
public class SpringUtils implements ApplicationContextAware {

    /**
     * Bean工厂
     */
    private static ApplicationContext applicationContext;

    /**
     * 获取Bean
     *
     * @param clazz 指定class
     * @param <T>   class类型
     * @return 获取到的class
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 获取Bean
     *
     * @param className 指定className
     * @return 获取到的class
     */
    public static Object getBean(String className) {
        return applicationContext.getBean(className);
    }

    /**
     * 通过构造方法注入Bean工厂
     *
     * @param applicationContext 被注入的工厂
     * @throws BeansException 异常
     */
    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }
}