package com.data.common.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应码
 *
 * @author jidaojiuyou
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    /**
     * 成功
     */
    SUCCESS("00000", "成功"),
    /**
     * 失败
     */
    FAILURE("99999", "失败"),
    /**
     * 验证码发送失败
     */
    VERIFICATION_CODE_SEND_FAILED("10000", "验证码发送失败"),
    /**
     * 验证码错误
     */
    VERIFICATION_CODE_ERROR("10100", "验证码错误"),
    /**
     * 验证码失效
     */
    VERIFICATION_CODE_INVALID("10200", "验证码失效"),
    /**
     * 请求类型错误
     */
    REQUEST_TYPE_ERROR("11100", "请求类型错误"),
    /**
     * 不支持该请求类型
     */
    REQUEST_TYPE_DENIED("11200", "不支持该请求类型"),
    /**
     * 文件上传失败
     */
    FILE_UPLOAD_FAILED("12000", "文件上传失败"),
    /**
     * 数据库连接失败异常
     */
    DATABASE_CONNECT_FAILED("13000", "数据库连接失败"),
    /**
     * Redis 连接失败
     */
    REDIS_CONNECT_FAILED("13100", "Redis连接失败"),
    /**
     * MySQL 连接失败
     */
    MYSQL_CONNECT_FAILED("13200", "MySQL连接失败"),
    /**
     * ORACLE 连接失败
     */
    ORACLE_CONNECT_FAILED("13300", "Oracle连接失败"),
    /**
     * SQL SERVER 连接失败
     */
    SQL_SERVER_CONNECT_FAILED("13400", "SQL_SERVER连接失败"),
    /**
     * MongoDB 连接失败
     */
    MONGO_CONNECT_FAILED("13500", "MongoDB连接失败"),
    /**
     * ES 连接失败
     */
    ES_CONNECT_FAILED("13600", "Elasticsearch连接失败"),
    /**
     * 注册登录错误
     */
    REGISTER_OR_LOGIN_ERROR("20000", "注册登录错误"),
    /**
     * 账号或密码不能为空
     */
    USERNAME_OR_PASSWORD_NOT_BE_EMPTY("20100", "账号或密码不能为空"),
    /**
     * 认证code不能为空
     */
    AUTH_CODE_NOT_BE_EMPTY("20200", "认证code不能为空"),
    /**
     * 认证code已失效
     */
    AUTH_CODE_INVALID("20300", "认证code已失效"),
    /**
     * 注册失败
     */
    REGISTER_FAILED("21000", "注册失败"),
    /**
     * 账号已存在
     */
    ACCOUNT_ALREADY_EXISTS("21100", "账号已存在"),
    /**
     * 登陆失败
     */
    LOGIN_FAILED("22000", "登陆失败"),
    /**
     * 账号或密码错误
     */
    USERNAME_OR_PASSWORD_ERROR("22100", "账号或密码错误"),
    /**
     * 账号已被锁定
     */
    ACCOUNT_IS_LOCKED("22200", "账号已被锁定"),
    /**
     * 账号未激活
     */
    ACCOUNT_NOT_ACTIVATED("22300", "账号未激活"),
    /**
     * 需要绑定手机号
     */
    NEED_BINDING_PHONE_NUMBER("22400", "需要绑定手机号"),
    /**
     * 账号不存在
     */
    ACCOUNT_NOT_EXISTS("22500", "账号不存在"),
    /**
     * 未登录
     */
    NOT_LOGGED_IN("23000", "未登录"),
    /**
     * 无token
     */
    TOKEN_IS_MISSING("23100", "无token"),
    /**
     * token无效
     */
    TOKEN_INVALID("23200", "token无效"),
    /**
     * token已过期
     */
    TOKEN_EXPIRED("23300", "token已过期"),
    /**
     * token被踢下线
     */
    TOKEN_REMOVED("23400", "token被踢下线"),
    /**
     * token被顶下线
     */
    TOKEN_REPLACED("23500", "token被顶下线"),
    /**
     * token超过有效期已被冻结
     */
    TOKEN_FREEZE("23600", "token超过有效期已被冻结"),
    /**
     * 未按照指定前缀提交token
     */
    NO_PREFIX("23700", "未按照指定前缀提交token"),
    /**
     * 数据错误
     */
    DATA_ERROR("30000", "数据错误"),
    /**
     * 数据已存在
     */
    DATA_ALREADY_EXISTS("30100", "数据已存在"),
    /**
     * 数据不存在
     */
    DATA_NOT_EXISTS("30200", "数据不存在"),
    /**
     * 新增错误
     */
    ADD_FAILED("31000", "新增错误"),
    /**
     * 删除错误
     */
    DELETE_FAILED("32000", "删除错误"),
    /**
     * 修改错误
     */
    UPDATE_FAILED("33000", "修改错误"),
    /**
     * 查询错误
     */
    QUERY_FAILED("34000", "查询错误"),
    /**
     * 格式错误
     */
    PARAM_FORMAT_ERROR("35000", "参数格式错误"),
    /**
     * 类型错误
     */
    PARAM_TYPE_ERROR("36000", "参数类型错误"),
    /**
     * 参数不能为空
     */
    PARAM_NOT_BE_EMPTY("37000", "参数不能为空"),
    /**
     * 参数范围错误
     */
    PARAM_OUT_OF_RANGE("38000", "参数范围错误"),
    /**
     * 参数校验错误
     */
    PARAM_CHECK_EXCEPTION("39000", "参数校验错误"),
    /**
     * 没有权限
     */
    PERMISSION_DENIED("40000", "没有权限"),
    /**
     * 服务器错误
     */
    SERVER_EXCEPTION("50000", "服务器错误"),
    /**
     * 临时停服
     */
    TEMPORARILY_STOP_SERVICE("50100", "临时停服"),
    /**
     * 服务升级中
     */
    SERVICE_UPDATING("50200", "服务升级中"),
    /**
     * 数据库异常
     */
    DATABASE_EXCEPTION("51000", "数据库异常");

    private final String code;
    private final String description;
}