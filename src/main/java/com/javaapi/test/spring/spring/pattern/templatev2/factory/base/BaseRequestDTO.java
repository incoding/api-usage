package com.javaapi.test.spring.spring.pattern.templatev2.factory.base;


import java.io.Serializable;

public class BaseRequestDTO implements Serializable {
    private static final long serialVersionUID = 7537931323348851402L;
    private String traceId;

    public BaseRequestDTO() {
    }

    public String getTraceId() {
        return this.traceId;
    }

    public BaseRequestDTO setTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    public String toString() {
        return "BaseRequestDTO{traceId='" + this.traceId + '\'' + '}';
    }
}
