package com.data.common.mp.ext.strategy;

/**
 * 字典值绑定策略
 *
 * @author jidaojiuyou
 */
public interface DictBindStrategy {

    /**
     * 通过字典id和字典项id获取字典名称
     *
     * @param dictId     字典id
     * @param dictItemId 字典项id
     * @return 字典项名称
     */
    String getDictItemNameByDictIdAndDictItemId(String dictId, String dictItemId);
}