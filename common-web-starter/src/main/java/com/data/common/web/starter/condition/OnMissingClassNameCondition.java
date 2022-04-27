package com.data.common.web.starter.condition;

import com.data.common.lang.util.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * 检查指定名称的 Bean 是否不在 Context
 *
 * @author jidaojiuyou
 */
public class OnMissingClassNameCondition implements Condition {
    /**
     * 匹配
     *
     * @param context  context
     * @param metadata 注解metadata
     * @return 是否匹配
     */
    @Override
    public boolean matches(@NotNull ConditionContext context, @NotNull AnnotatedTypeMetadata metadata) {
        // 先取出注解的值
        String classes = (String) Objects.requireNonNull(metadata.getAnnotationAttributes("com.data.common.web.starter.annotation.ConditionalOnMissingClassName")).get("classes");
        // 获取beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 查看Context里面是否有同名Bean
        try {
            // 正常能获取到则不会抛出异常
            Objects.requireNonNull(beanFactory).getBean(StringUtils.switchFirstLetter(classes, false));
            // 抛出异常则说明bean不存在
        } catch (NoSuchBeanDefinitionException e) {
            return true;
        }
        return false;
    }
}