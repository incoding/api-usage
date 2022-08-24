
package com.javaapi.test.spring.spring.pattern.template.serviceproxy;

import com.javaapi.test.spring.spring.pattern.template.core.TradeServiceEnum;
import com.javaapi.test.spring.spring.pattern.template.enums.OrderSourceEnum;
import com.javaapi.test.spring.spring.pattern.template.enums.ResourceTypeEnum;
import com.javaapi.test.spring.spring.pattern.template.exception.APIException;

import java.io.Serializable;

/**
 * Facade层服务网关接口
 */
public interface TradeServiceProxy<Request extends Serializable, Response extends Serializable> {

    /**
     * API服务入口，根据服务方法，调度具体的业务接口执行业务逻辑
     *
     * @param request API request
     * @param service Trade service enum
     * @param channel Trade channel enum
     * @param source  Order source enum
     * @return API response
     * @throws APIException
     */
    Response invoke(Request request, TradeServiceEnum service, ResourceTypeEnum channel, OrderSourceEnum source) throws APIException;
}
