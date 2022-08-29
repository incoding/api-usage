package com.javaapi.test.spring.spring.pattern.templatev2.factory.registry;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseRequestDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseResponseDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.converter.Converter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.filter.GatewayFilter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.formatter.Formatter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.invoker.Invoker;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.validator.Validator;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface GatewayServiceRegister<Request extends BaseRequestDTO, Response extends BaseResponseDTO, InVO extends Serializable, OutVO extends Serializable> {

    /**
     * 获取网关服务参数、业务校验器
     *
     * @param serviceName
     * @return
     */
    Validator<Request> retrieveValidator(String serviceName);

    /**
     * 获取网关服务入参、出参数据转换器
     *
     * @param serviceName
     * @return
     */
    Converter<Request, Response, InVO, OutVO> retrieveConverter(String serviceName);

    /**
     * 获取网关服务代理服务接口
     *
     * @param serviceName
     * @return
     */
    Invoker<InVO, OutVO> retrieveProxyService(String serviceName);

    /**
     * 获取网关服务过滤器，过滤器分为前处理过滤器，后处理过滤器
     *
     * @param type
     * @return
     */
    List<GatewayFilter<InVO, OutVO>> findFiltersByType(String type);

    /**
     * 获取网关服务参数、业务校验器
     *
     * @param serviceName
     * @return
     */
    Formatter<Request, Response, InVO, OutVO> retrieveFormatter(String serviceName);

}
