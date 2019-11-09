package com.javaapi.test.buisness.joint.exception;

import com.javaapi.test.buisness.joint.error.BaseError;
import com.javaapi.test.buisness.joint.error.BaseErrorConstant;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private BaseError error;
    private Object ext;

    public <T> T getExt() {
        return (T) ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public BusinessException() {
        super();
    }

    public BusinessException(BaseError error) {
        super(error.getMsg());
        this.error = error;
    }

    public BusinessException(BaseError error, Throwable cause) {
        super(error.getMsg(), cause);
        this.error = error;
    }

    public BusinessException(String message) {
        super(message);
        this.error = new BaseError(BaseErrorConstant.G_ERROR, message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.error = new BaseError(BaseErrorConstant.G_ERROR, message);
    }

    public BusinessException(String key, String message) {
        super(message);
        this.error = new BaseError(key, message);
    }

    public BusinessException(String key, String message, Throwable cause) {
        super(message, cause);
        this.error = new BaseError(key, message);
    }

    public String getMsg() {
        return error.getMsg();
    }

    public String getCode() {
        return error.getCode();
    }

    public BaseError getError() {
        return error;
    }

    public void setError(BaseError error) {
        this.error = error;
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
