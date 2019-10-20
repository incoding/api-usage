package com.javaapi.test.spring.spring.custom.registry.exceptionhandler.model;

/**
 * Created by user on 2019/10/20
 */
public class ExceptionContext<P, R> {
    private String code;
    private String message;

    public ExceptionContext() {
    }


    public ExceptionContext(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
