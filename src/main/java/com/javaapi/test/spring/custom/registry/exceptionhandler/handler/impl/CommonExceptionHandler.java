package com.javaapi.test.spring.custom.registry.exceptionhandler.handler.impl;

import com.javaapi.test.spring.custom.registry.exceptionhandler.handler.ExceptionHandler;
import com.javaapi.test.spring.custom.registry.exceptionhandler.model.ExceptionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/10/19
 */
@Component
public class CommonExceptionHandler implements ExceptionHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 异常处理顺序
     *
     * @return
     */
    @Override
    public Integer getOrder() {
        return 1;
    }

    /**
     * 获得处理的errorCode
     *
     * @return
     */
    @Override
    public String getCode() {
        return "390";
    }

    @Override
    public void handle(ExceptionContext exceptionHandler) {
        String message = exceptionHandler.getMsg();
        if (message.contains("common error")) {
            logger.error("发现普通错误,code={} message={}", message);
        }
        exceptionHandler.setNeedContinue(true);
    }
}
