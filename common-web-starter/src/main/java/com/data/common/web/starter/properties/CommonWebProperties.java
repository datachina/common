package com.data.common.web.starter.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置
 *
 * @author jidaojiuyou
 */
@ConfigurationProperties(prefix = "data.common")
@Getter
@Setter
public class CommonWebProperties {
    /**
     * 异常拦截器配置
     */
    private ExceptionHandler exceptionHandler;
    /**
     * 跨域配置
     */
    private DefaultCorsConfig defaultCors;

    /**
     * 跨域配置
     */
    @Getter
    @Setter
    public static class DefaultCorsConfig{
        /**
         * 是否启用
         */
        private Boolean enable = false;
    }

    /**
     * 异常拦截器
     */
    @Getter
    @Setter
    public static class ExceptionHandler {
        /**
         * 全局配置
         */
        private Global global;
        /**
         * 新增异常拦截器的配置
         */
        private Add add;
        /**
         * 删除异常拦截器的配置
         */
        private Delete delete;
        /**
         * 修改异常拦截器的配置
         */
        private Update update;
        /**
         * 查询异常拦截器的配置
         */
        private Query query;
        /**
         * 参数校验异常拦截器的配置
         */
        private Validate validate;

        /**
         * 全局配置
         */
        @Getter
        @Setter
        public static class Global {
            /**
             * 是否打印错误栈
             */
            private Boolean printStackTrace = false;
            /**
             * 是否打印日志
             */
            private Boolean printLog = true;
        }

        /**
         * 新增异常拦截器的配置
         */
        @Getter
        @Setter
        public static class Add {
            /**
             * 是否启用
             */
            private Boolean enable = false;
            /**
             * 是否打印错误栈
             */
            private Boolean printStackTrace;
            /**
             * 是否打印日志
             */
            private Boolean printLog;
        }

        /**
         * 删除异常拦截器的配置
         */
        @Getter
        @Setter
        public static class Delete {
            /**
             * 是否启用
             */
            private Boolean enable = false;
            /**
             * 是否打印错误栈
             */
            private Boolean printStackTrace;
            /**
             * 是否打印日志
             */
            private Boolean printLog;
        }

        /**
         * 修改异常拦截器的配置
         */
        @Getter
        @Setter
        public static class Update {
            /**
             * 是否启用
             */
            private Boolean enable = false;
            /**
             * 是否打印错误栈
             */
            private Boolean printStackTrace;
            /**
             * 是否打印日志
             */
            private Boolean printLog;
        }

        /**
         * 查询异常拦截器的配置
         */
        @Getter
        @Setter
        public static class Query {
            /**
             * 是否启用
             */
            private Boolean enable = false;
            /**
             * 是否打印错误栈
             */
            private Boolean printStackTrace;
            /**
             * 是否打印日志
             */
            private Boolean printLog;
        }

        /**
         * 参数校验异常拦截器的配置
         */
        @Getter
        @Setter
        public static class Validate {
            /**
             * 是否启用
             */
            private Boolean enable = false;
            /**
             * 是否打印错误栈
             */
            private Boolean printStackTrace;
            /**
             * 是否打印日志
             */
            private Boolean printLog;
        }
    }
}