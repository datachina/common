package com.data.common.web.page;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 简单分页
 *
 * @author jidaojiuyou
 */
public interface SimplePage<T> {

    /**
     * 获取列表
     *
     * @return 对象列表
     */
    @JsonProperty("list")
    List<T> getList();

    /**
     * 总条数
     *
     * @return 总条数
     */
    @JsonProperty("total")
    Long getTotal();

    /**
     * PageSize
     *
     * @return pageSize
     */
    @JsonProperty("pageSize")
    Integer getPageSize();

    /**
     * PageNum
     *
     * @return pageNum
     */
    @JsonProperty("pageNum")
    Integer getPageNum();
}