package com.javaapi.test.spring.spring.pattern.templatev2.factory.invoker;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.ResponseContext;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.InvokerException;

import java.io.Serializable;

/**
 *
 */
public interface Invoker<Req extends Serializable, Res extends Serializable> {

    /**
     * 网关业务逻辑实现接口方法
     *
     * @param req
     * @return
     * @throws InvokerException
     */
    ResponseContext<Res> invoke(Req req) throws InvokerException;

}
