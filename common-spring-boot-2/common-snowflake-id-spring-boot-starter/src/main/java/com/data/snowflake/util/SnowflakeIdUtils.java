package com.data.snowflake.util;

import com.github.yitter.idgen.YitIdHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 雪花 id 工具
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SnowflakeIdUtils {
    public static long nextId() {
        return YitIdHelper.nextId();
    }
}