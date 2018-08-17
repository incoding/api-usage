package com.javaapi.test.buisness.exception.bussiness.exception_v2.exception;

import java.util.Map;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ErrorCode errorCode;
    private Object ext;

    public <T> T getExt() {
        return (T)ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public BusinessException() {
        super();
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMsg(), cause);
        this.errorCode = errorCode;
    }

    public BusinessException(String message) {
        super(message);
        this.errorCode = new ErrorCode(ErrorCode.BUSINESS_COMMON_ERROR, message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = new ErrorCode(ErrorCode.BUSINESS_COMMON_ERROR, message);
    }

    public BusinessException(String key,String message) {
        super(message);
        this.errorCode = new ErrorCode(key, message);
    }

    public BusinessException(String key,String message, Throwable cause) {
        super(message, cause);
        this.errorCode = new ErrorCode(key, message);
    }

    public String getMsg() {
        return errorCode.getMsg();
    }

    public String getKey() {
        return errorCode.getKey();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, Object> getExtra() {
        return errorCode.getExtra();
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
