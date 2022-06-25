package com.data.common.web.starter.condition;

import com.data.common.lang.util.StringUtils;
import com.data.common.web.starter.annotation.ConditionalOnMissingClassName;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Objects;

/**
 * 检查指定名称的 Bean 是否不在 Context
 *
 * @author jidaojiuyou
 */
public class OnMissingClassNameCondition implements Condition {

    /**
     * 注解字段
     */
    public static final String ANNOTATION_FIELD = "classes";

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
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnMissingClassName.class.getName());
        // 如果注解不存在或classes的key不存在或值为空,则正常加载
        if (annotationAttributes == null || !annotationAttributes.containsKey(ANNOTATION_FIELD) || Objects.equals("", annotationAttributes.get(ANNOTATION_FIELD))) {
            // 返回true则正常加载
            return true;
        }
        // 获取到的classes值
        String classes = (String) annotationAttributes.get(ANNOTATION_FIELD);
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