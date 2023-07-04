package com.data.common.mp.ext.factory;

import com.data.common.mp.ext.strategy.DictBindStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 字典值绑定策略工厂
 *
 * @author jidaojiuyou
 */
@Component
@RequiredArgsConstructor
public class DictBindStrategyFactory {

    /**
     * 自动注入策略实现类
     */
    private final Map<String, DictBindStrategy> dictBindStrategyMap;

    /**
     * 获取策略
     *
     * @param name 策略名称，使用@Component标注策略
     * @return 策略
     */
    public DictBindStrategy getDictBindStrategy(String name) {
        var dictBindStrategy = dictBindStrategyMap.get(name);
        if (dictBindStrategy == null) {
            return getDictBindStrategy("defaultBind");
        }
        return dictBindStrategy;
    }
}