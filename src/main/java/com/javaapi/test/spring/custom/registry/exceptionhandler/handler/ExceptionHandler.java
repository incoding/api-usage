package com.javaapi.test.spring.custom.registry.exceptionhandler.handler;

import com.javaapi.test.spring.custom.registry.exceptionhandler.model.ExceptionContext;

/**
 * 异常处理器
 */
public interface ExceptionHandler {

    /**
     * 异常处理顺序
     *
     * @return
     */
    public Integer getOrder();

    /**
     * 获得处理的errorCode
     *
     * @return
     */
    public String getCode();

    void handle(ExceptionContext exceptionHandler);
}
