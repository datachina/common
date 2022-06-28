package com.data.common.web.starter.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置类
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
    private ExceptionHandlerConfig exceptionHandler;
    /**
     * 跨域配置
     */
    private DefaultCorsConfig defaultCors;

    /**
     * 跨域配置类
     */
    @Getter
    @Setter
    public static class DefaultCorsConfig {
        /**
         * 是否启用默认跨域配置.
         */
        private Boolean enable = false;
    }

    /**
     * 异常拦截器配置类
     */
    @Getter
    @Setter
    public static class ExceptionHandlerConfig {
        /**
         * 异常拦截器全局配置
         */
        private Global global;
        /**
         * 新增异常拦截器配置
         */
        private Add add;
        /**
         * 删除异常拦截器配置
         */
        private Delete delete;
        /**
         * 修改异常拦截器配置
         */
        private Update update;
        /**
         * 查询异常拦截器配置
         */
        private Query query;
        /**
         * 参数校验异常拦截器配置
         */
        private Validate validate;
        /**
         * Redis连接异常拦截器配置
         */
        private RedisConnectFailure redisConnectFailure;
        /**
         * SQL异常拦截器配置
         */
        private Sql sql;

        /**
         * 异常拦截器全局配置类
         */
        @Getter
        @Setter
        public static class Global {
            /**
             * 是否全局启用打印异常栈.
             */
            private Boolean printStackTrace = false;
            /**
             * 是否全局启用打印错误日志.
             */
            private Boolean printLog = true;
        }

        /**
         * 新增异常拦截器配置类
         */
        @Getter
        @Setter
        public static class Add {
            /**
             * 是否启用新增异常拦截器.
             */
            private Boolean enable = false;
            /**
             * 是否启用新增异常拦截器打印异常栈.
             */
            private Boolean printStackTrace;
            /**
             * 是否启用新增异常拦截器打印错误日志.
             */
            private Boolean printLog;
        }

        /**
         * 删除异常拦截器配置类
         */
        @Getter
        @Setter
        public static class Delete {
            /**
             * 是否启用删除异常拦截器.
             */
            private Boolean enable = false;
            /**
             * 是否启用删除异常拦截器打印异常栈.
             */
            private Boolean printStackTrace;
            /**
             * 是否启用删除异常拦截器打印错误日志.
             */
            private Boolean printLog;
        }

        /**
         * 修改异常拦截器配置类
         */
        @Getter
        @Setter
        public static class Update {
            /**
             * 是否启用修改异常拦截器.
             */
            private Boolean enable = false;
            /**
             * 是否启用修改异常拦截器打印异常栈.
             */
            private Boolean printStackTrace;
            /**
             * 是否启用修改异常拦截器打印错误日志.
             */
            private Boolean printLog;
        }

        /**
         * 查询异常拦截器配置类
         */
        @Getter
        @Setter
        public static class Query {
            /**
             * 是否启用查询异常拦截器.
             */
            private Boolean enable = false;
            /**
             * 是否启用查询异常拦截器打印异常栈.
             */
            private Boolean printStackTrace;
            /**
             * 是否启用查询异常拦截器打印错误日志.
             */
            private Boolean printLog;
        }

        /**
         * 参数校验异常拦截器配置类
         */
        @Getter
        @Setter
        public static class Validate {
            /**
             * 是否启用参数校验异常拦截器.
             */
            private Boolean enable = false;
            /**
             * 是否启用参数校验异常拦截器打印异常栈.
             */
            private Boolean printStackTrace;
            /**
             * 是否启用参数校验异常拦截器打印错误日志.
             */
            private Boolean printLog;
        }

        /**
         * 参数校验异常拦截器配置类
         */
        @Getter
        @Setter
        public static class RedisConnectFailure {
            /**
             * 是否启用Redis连接异常拦截器.
             */
            private Boolean enable = false;
            /**
             * 是否启用Redis连接异常拦截器打印异常栈.
             */
            private Boolean printStackTrace;
            /**
             * 是否启用Redis连接异常拦截器打印错误日志.
             */
            private Boolean printLog;
        }

        /**
         * SQL异常拦截器配置类
         */
        @Getter
        @Setter
        public static class Sql {
            /**
             * 是否启用SQL异常拦截器.
             */
            private Boolean enable = false;
            /**
             * 是否启用SQL异常拦截器打印异常栈.
             */
            private Boolean printStackTrace;
            /**
             * 是否启用SQL异常拦截器打印错误日志.
             */
            private Boolean printLog;
        }
    }
}