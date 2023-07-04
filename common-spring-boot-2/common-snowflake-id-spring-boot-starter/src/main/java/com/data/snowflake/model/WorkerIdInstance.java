package com.data.snowflake.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * 服务实例
 *
 * @author jidaojiuyou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
public class WorkerIdInstance implements Serializable {

    private static final long serialVersionUID = -7942113170244787245L;

    /**
     * 全局唯一实例
     */
    private static WorkerIdInstance instance;
    /**
     * workerId
     */
    private Short workerId;
    /**
     * 实例标识自己用的
     */
    private String uuid;

    /**
     * 单例
     *
     * @return instance
     */
    public static WorkerIdInstance getInstance() {
        if (instance == null) {
            instance = new WorkerIdInstance();
            instance.setUuid(UUID.randomUUID().toString());
        }
        return instance;
    }
}