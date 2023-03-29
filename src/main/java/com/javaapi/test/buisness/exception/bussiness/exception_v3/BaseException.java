package com.javaapi.test.buisness.exception.bussiness.exception_v3;

public class BaseException extends RuntimeException {
    private IResponseEnum responseEnum;
    private Object[] args;

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(message);
        this.responseEnum = responseEnum;
        this.args = args;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.responseEnum = responseEnum;
        this.args = args;
    }
}
