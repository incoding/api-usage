package com.javaapi.test.buisness.joint.exception;

import com.javaapi.test.buisness.joint.error.BaseError;
import com.javaapi.test.buisness.joint.error.BaseErrorConstant;

public class BusinessCheckedException extends Exception {
    private static final long serialVersionUID = 1L;
    private BaseError errorCode;
    private Object ext;

    public <T> T getExt() {
        return (T) ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public BusinessCheckedException() {
        super();
    }

    public BusinessCheckedException(BaseError errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public BusinessCheckedException(BaseError errorCode, Throwable cause) {
        super(errorCode.getMsg(), cause);
        this.errorCode = errorCode;
    }

    public BusinessCheckedException(String message) {
        super(message);
        this.errorCode = new BaseError(BaseErrorConstant.G_ERROR, message);
    }

    public BusinessCheckedException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = new BaseError(BaseErrorConstant.G_ERROR, message);
    }

    public BusinessCheckedException(String key, String message) {
        super(message);
        this.errorCode = new BaseError(key, message);
    }

    public BusinessCheckedException(String key, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = new BaseError(key, message);
    }

    public String getMsg() {
        return errorCode.getMsg();
    }

    public String getKey() {
        return errorCode.getCode();
    }

    public BaseError getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(BaseError errorCode) {
        this.errorCode = errorCode;
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
