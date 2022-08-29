package com.javaapi.test.spring.spring.pattern.templatev2.factory.exception;

/**
 *
 */
public enum BizErrorCodeEnum {


    ;

    private String code;
    private String message;

    BizErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}