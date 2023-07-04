package com.data.common.mp.ext.interceptor;


import cn.hutool.core.util.ReflectUtil;
import com.data.common.mp.ext.annotation.DictBind;
import com.data.common.mp.ext.factory.DictBindStrategyFactory;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.Collection;

/**
 * 字典值绑定拦截器
 *
 * @author jidaojiuyou
 */
@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
@Component
@Slf4j
@ConditionalOnClass(Intercepts.class)
public class DictBindInterceptor implements Interceptor {

    @Resource
    private DictBindStrategyFactory dictBindStrategyFactory;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return setDictName(invocation.proceed());
    }

    @Override
    public Object plugin(Object target) {
        return target instanceof ResultSetHandler ? Plugin.wrap(target, this) : target;
    }

    private Object setDictName(Object result) {
        if (result instanceof Collection<?> res) {
            return res.parallelStream().map(this::setDictName).toList();
        }

        var fs = ReflectUtil.getFields(result.getClass());
        for (Field f : fs) {
            DictBind annotation = f.getAnnotation(DictBind.class);
            if (annotation == null) {
                continue;
            }
            var dictItemId = String.valueOf(ReflectUtil.getFieldValue(result, f));
            var dictBindStrategy = dictBindStrategyFactory.getDictBindStrategy(annotation.strategy());
            var dictItemName = dictBindStrategy.getDictItemNameByDictIdAndDictItemId(annotation.dictId(), dictItemId);
            if (ReflectUtil.hasField(result.getClass(), annotation.targetField())) {
                log.debug("实体{}设置字段{}的值为{}", result, annotation.targetField(), dictItemName);
                ReflectUtil.setFieldValue(result, annotation.targetField(), dictItemName);
            } else {
                log.error("实体{}设置字段{}的值失败,字段{}不存在", result, annotation.targetField(), annotation.targetField());
            }
        }
        return result;
    }
}