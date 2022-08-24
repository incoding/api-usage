
package com.javaapi.test.spring.spring.pattern.template.core;


import com.javaapi.test.spring.spring.pattern.template.exception.TradeServiceException;

import java.io.Serializable;

/**
 * API服务调用器
 */
public interface TradeServiceInvoker<Request extends Serializable, Response extends Serializable> {

    /**
     * API服务接口定义
     *
     * @param request API入参
     * @return API出参
     * @throws TradeServiceException 交易服务异常
     */
    TradeResponse<Response> invoke(Request request) throws TradeServiceException;
}
