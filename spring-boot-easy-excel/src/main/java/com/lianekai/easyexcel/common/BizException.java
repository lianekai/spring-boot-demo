package com.lianekai.easyexcel.common;

/**
 * 自定义业务异常
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/13 20:54
 */
public class BizException extends RuntimeException{
    private String code;
    private transient Object data;

    public BizException() {
    }

    public BizException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(String code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public BizException(String message) {
        super(message);
        this.code = ResultEnum.BUSINESS_ERROR.getCode();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public BizException setData(Object data) {
        this.data = data;
        return this;
    }
}
