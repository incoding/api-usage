package com.javaapi.test.spring.spring.pattern.templatev2.factory.context;

import java.io.Serializable;

/**
 *
 */
public class ResponseContext<T extends Serializable> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 返回主体内容
     */
    private T response;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 消息代码
     */
    private String code;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 错误内容
     */
    private String errorMsg;

    /**
     * 需要传递的其他信息.
     */
    private Object obj;

    /**
     * 空参构造函数
     */
    public ResponseContext() {
    }

    /**
     * 带参数构造函数
     *
     * @param success
     * @param code
     * @param message
     */
    public ResponseContext(boolean success, String code, String message) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 带参数构造函数
     *
     * @param response
     * @param success
     * @param code
     * @param message
     */
    public ResponseContext(T response, boolean success, String code, String message) {
        super();
        this.response = response;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ResponseContext(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public ResponseContext<T> setResponse(T response) {
        this.response = response;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public ResponseContext<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ResponseContext<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseContext<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}