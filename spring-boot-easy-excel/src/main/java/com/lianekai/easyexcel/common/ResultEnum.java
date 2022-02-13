package com.lianekai.easyexcel.common;

import lombok.Getter;

/**
 * 可能返回的结果每枚举
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/11 21:26
 */
@Getter
public enum  ResultEnum {

    SUCCESS("200", "请求成功"),
    PARAMS_IS_NULL("1001", "参数为空"),
    PARAMS_NOT_COMPLETE("1002", "参数不全"),
    PARAMS_TYPE_ERROR("1003", "参数类型错误"),
    PARAMS_IS_INVALID("1004", "参数无效"),
    USER_NOT_EXIST("2001", "用户不存在"),
    USER_NOT_LOGGED_IN("2002", "用户未登陆"),
    USER_ACCOUNT_ERROR("2003", "用户名或密码错误"),
    USER_ACCOUNT_FORBIDDEN("2004", "用户账户已被禁用"),
    USER_HAS_EXIST("2005", "用户已存在"),
    USER_PHONE_HAS_EXIST("2006", "手机号已存在"),
    USER_EMAIL_HAS_EXIST("2007", "邮箱已存在"),
    BUSINESS_ERROR("3001", "系统业务出现问题"),
    ERROR("500", "系统开小差去了，请稍后重试"),
    DATA_NOT_FOUND("5001", "数据未找到"),
    DATA_IS_WRONG("5002", "数据有误"),
    DATA_ALREADY_EXISTED("5003", "数据已存在"),
    INTERFACE_INNER_INVOKE_ERROR("6001", "系统内部接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR("6002", "系统外部接口调用异常"),
    INTERFACE_FORBIDDEN("6003", "接口禁止访问"),
    INTERFACE_ADDRESS_INVALID("6004", "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT("6005", "接口请求超时"),
    PERMISSION_NO_ACCESS("7001", "没有访问权限");

    private String code;
    private String message;

    private ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(String code){
        for(ResultEnum e:values()){
            if (e.code.equals(code)){
                return e.message;
            }
        }
        return "";
    }
}
