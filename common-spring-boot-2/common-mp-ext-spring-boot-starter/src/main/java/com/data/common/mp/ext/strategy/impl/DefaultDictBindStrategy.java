package com.data.common.mp.ext.strategy.impl;

import com.data.common.mp.ext.strategy.DictBindStrategy;
import org.springframework.stereotype.Component;

/**
 * 默认的字典值绑定策略实现
 *
 * @author jidaojiuyou
 */
@Component(DefaultDictBindStrategy.STRATEGY_NAME)
public class DefaultDictBindStrategy implements DictBindStrategy {

    /**
     * Bean的名称
     */
    public static final String STRATEGY_NAME = "defaultBind";

    /**
     * 通过字典id和字典项id获取字典名称
     *
     * @param dictId     字典id
     * @param dictItemId 字典项id
     * @return 字典项名称
     */
    @Override
    public String getDictItemNameByDictIdAndDictItemId(String dictId, String dictItemId) {
        return null;
    }
}