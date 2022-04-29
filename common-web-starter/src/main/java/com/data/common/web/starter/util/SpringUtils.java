package com.data.common.web.starter.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring工具类
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@Getter
public class SpringUtils implements ApplicationContextAware {

    /**
     * Bean工厂
     */
    private ApplicationContext applicationContext;

    /**
     * 通过构造方法注入Bean工厂
     *
     * @param applicationContext 被注入的工厂
     * @throws BeansException 异常
     */
    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取Bean
     *
     * @param clazz 指定class
     * @param <T>   class类型
     * @return 获取到的class
     */
    public <T> T getBean(Class<T> clazz) {
        return this.applicationContext.getBean(clazz);
    }

    /**
     * 获取Bean
     *
     * @param className 指定className
     * @return 获取到的class
     */
    public Object getBean(String className) {
        return this.applicationContext.getBean(className);
    }
}