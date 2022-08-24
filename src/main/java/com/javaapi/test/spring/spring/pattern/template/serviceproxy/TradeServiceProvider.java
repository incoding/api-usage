
package com.javaapi.test.spring.spring.pattern.template.serviceproxy;

import com.javaapi.test.spring.spring.pattern.template.converter.request.RequestConverter;
import com.javaapi.test.spring.spring.pattern.template.converter.response.ResponseConverter;
import com.javaapi.test.spring.spring.pattern.template.core.TradeServiceInvoker;
import com.javaapi.test.spring.spring.pattern.template.validator.Validator;

import java.io.Serializable;

/**
 * 交易、订单服务调用器提供者
 */
public interface TradeServiceProvider<Request extends Serializable, Response extends Serializable, InnerRequest extends Serializable, InnerResponse extends Serializable> {

    /**
     * 获取API服务参数、业务校验器
     *
     * @param serviceId
     * @return
     */
    Validator<Request> retrieveValidator(String serviceId);

    /**
     * 获取API服务代理服务接口
     *
     * @param serviceId
     * @return
     */
    TradeServiceInvoker<InnerRequest, InnerResponse> retrieveTradeService(String serviceId);

    /**
     * 获取API服务代理服务接口
     *
     * @param serviceId
     * @return
     */
    RequestConverter<Request, InnerRequest> retrieveRequestConverter(String serviceId);

    /**
     * 获取API服务代理服务接口
     *
     * @param serviceId
     * @return
     */
    ResponseConverter<Response, InnerResponse> retrieveResponseConverter(String serviceId);

}
