package com.data.common.web.starter.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 注入排序
 *
 * @author jidaojiuyou
 * @see org.springframework.core.Ordered
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanOrdered {

    /**
     * 高优先级
     */
    public static final int HIGH_PRECEDENCE = -100;
    /**
     * 低优先级
     */
    public static final int LOW_PRECEDENCE = 100;
}