package com.javaapi.test.spring.spring.pattern.templatev2.factory;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseRequestDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseResponseDTO;

import java.io.Serializable;

/**
 *
 */
public interface GatewayServiceFactory<Request extends BaseRequestDTO, Response extends BaseResponseDTO, InVO extends Serializable, OutVO extends Serializable> {

    /**
     * 网关入口，根据服务网关方法，调度具体的业务接口执行业务逻辑
     *
     * @param gatewayMethod
     * @param request
     * @param response
     * @return
     */
    Response invoke(GatewayMethodEnum gatewayMethod, Request request, Response response);
}
