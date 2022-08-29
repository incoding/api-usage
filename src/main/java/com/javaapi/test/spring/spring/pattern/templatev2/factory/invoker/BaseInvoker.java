package com.javaapi.test.spring.spring.pattern.templatev2.factory.invoker;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.ResponseContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;

/**
 * 基础服务类
 */
public abstract class BaseInvoker implements InitializingBean {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void afterPropertiesSet() throws IllegalArgumentException {

    }

    public <T extends Serializable> ResponseContext<T> createBaseResult() {
        ResponseContext<T> responseContext = new ResponseContext<>();
        responseContext.setSuccess(true);
        responseContext.setMessage("成功");
        return responseContext;
    }

    public <T extends Serializable> ResponseContext<T> createFailResult() {
        ResponseContext<T> responseContext = new ResponseContext<>();
        responseContext.setSuccess(false);
        responseContext.setMessage("失败");
        return responseContext;
    }

    public <T extends Serializable> ResponseContext<T> createFailResult(String code, String message) {
        ResponseContext<T> responseContext = new ResponseContext<>();
        responseContext.setSuccess(false);
        responseContext.setCode(code);
        responseContext.setMessage(message);
        return responseContext;
    }

    public <T extends Serializable> ResponseContext<T> createBaseResult(T t) {
        ResponseContext<T> ret = new ResponseContext<>();
        ret.setSuccess(true);
        ret.setMessage("成功");
        ret.setResponse(t);
        return ret;
    }
}