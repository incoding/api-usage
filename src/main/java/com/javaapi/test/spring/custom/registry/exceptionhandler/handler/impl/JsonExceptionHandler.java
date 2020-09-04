package com.javaapi.test.spring.custom.registry.exceptionhandler.handler.impl;

import com.javaapi.test.buisness.joint.result.base.BaseResult;
import com.javaapi.test.spring.custom.registry.exceptionhandler.handler.ExceptionHandler;
import com.javaapi.test.spring.custom.registry.exceptionhandler.handler.constants.ExceptionHandlerConstants;
import com.javaapi.test.spring.custom.registry.exceptionhandler.model.ExceptionContext;
import org.springframework.stereotype.Component;

/**
 * 默认的异常处理器
 * 默认返回JSON
 */
@Component
public class JsonExceptionHandler implements ExceptionHandler {

    /**
     * 异常处理顺序
     *
     * @return
     */
    @Override
    public Integer getOrder() {
        return Integer.MAX_VALUE;
    }

    /**
     * 获得处理的errorCode
     *
     * @return
     */
    @Override
    public String getCode() {
        return ExceptionHandlerConstants.EXCEPTION_DEFAULT_HANDLER;
    }

    @Override
    public void handle(ExceptionContext exceptionHandler) {
        BaseResult tBaseResult = BaseResult.newError(exceptionHandler.getException().getError());
        exceptionHandler.setResult(tBaseResult);
        exceptionHandler.setNeedContinue(false);
    }
}
