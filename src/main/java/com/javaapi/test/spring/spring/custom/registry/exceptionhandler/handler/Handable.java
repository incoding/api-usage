package com.javaapi.test.spring.spring.custom.registry.exceptionhandler.handler;

import com.javaapi.test.spring.spring.custom.registry.exceptionhandler.model.ExceptionContext;

/**
 * Created by user on 2019/11/9
 */
public interface Handable {
    void handle(ExceptionContext exceptionHandler);
}
