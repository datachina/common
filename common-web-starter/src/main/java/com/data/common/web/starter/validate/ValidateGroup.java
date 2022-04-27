package com.data.common.web.starter.validate;

import javax.validation.groups.Default;

/**
 * 参数校验组
 *
 * @author jidaojiuyou
 */
@SuppressWarnings("unused")
public interface ValidateGroup extends Default {

    /**
     * 标准crud
     */
    interface Crud extends ValidateGroup {

        /**
         * 增
         */
        interface Create extends Crud {

        }

        /**
         * 删
         */
        interface Delete extends Crud {

        }

        /**
         * 改
         */
        interface Update extends Crud {

        }

        /**
         * 查
         */
        interface Query extends Crud {

        }
    }
}