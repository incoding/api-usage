package com.javaapi.test.spring.spring.pattern.templatev2.factory.registry.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.annotation.Gateway;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseRequestDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseResponseDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.converter.Converter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.filter.GatewayFilter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.formatter.Formatter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.invoker.Invoker;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.registry.GatewayServiceRegister;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.validator.Validator;
import com.javaapi.test.spring.spring.util.AopTargetUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 服务网关提供商默认实现，系统启动时，注册各类服务
 */
@Service
public class DefaultGatewayServiceRegister<Request extends BaseRequestDTO, Response extends BaseResponseDTO, InVO extends Serializable, OutVO extends Serializable>
        implements GatewayServiceRegister<Request, Response, InVO, OutVO>, InitializingBean {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DefaultGatewayServiceRegister.class);
    /**
     * spring上下文
     */
    @Resource
    private ApplicationContext applicationContext;
    /**
     * 服务扩展过滤器
     */
    private final Map<String, List<GatewayFilter<InVO, OutVO>>> GATEWAY_FILTERS = Maps.newConcurrentMap();
    /**
     * 网关服务集合
     */
    private final Map<String, Invoker<InVO, OutVO>> GATEWAY_SERVICES = Maps.newConcurrentMap();
    /**
     * 数据转换器集合
     */
    private final Map<String, Converter<Request, Response, InVO, OutVO>> GATEWAY_CONVERTERS = Maps.newConcurrentMap();
    /**
     * 数据校验器集合
     */
    private final Map<String, Validator<Request>> GATEWAY_VALIDATORS = Maps.newConcurrentMap();
    /**
     * Response格式化集合
     */
    private final Map<String, Formatter<Request, Response, InVO, OutVO>> GATEWAY_FORMATTERS = Maps.newConcurrentMap();

    /**
     * @see InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() {
        // 注册网关服务
        registerGatewayServices();
        // 注册网关服务校验器
        registerValidators();
        // 注册网关服务数据转换器
        registerConverters();
        // 注册过滤器
        registerFilters();
        // 注册格式化器
        registerFormatters();
    }

    @Override
    public Validator<Request> retrieveValidator(String serviceName) {
        return GATEWAY_VALIDATORS.get(serviceName);
    }

    @Override
    public Converter<Request, Response, InVO, OutVO> retrieveConverter(String serviceName) {
        return GATEWAY_CONVERTERS.get(serviceName);
    }

    @Override
    public Invoker<InVO, OutVO> retrieveProxyService(String serviceName) {
        return GATEWAY_SERVICES.get(serviceName);
    }

    @Override
    public List<GatewayFilter<InVO, OutVO>> findFiltersByType(String type) {
        return Collections.unmodifiableList(GATEWAY_FILTERS.getOrDefault(type, Lists.newArrayList()));
    }

    @Override
    public Formatter<Request, Response, InVO, OutVO> retrieveFormatter(String serviceName) {
        return GATEWAY_FORMATTERS.get(serviceName);
    }

    // ~ protected方法 ----------------------------------------------------------------------------------------------------------------

    /**
     * 系统启动时，注册系统中的网关服务
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected void registerGatewayServices() {
        Map<String, Invoker> services = applicationContext.getBeansOfType(Invoker.class, false, true);

        if (MapUtils.isEmpty(services)) {
            throw new IllegalStateException("Cannot register Invoker, please make sure the Invoker setup as spring bean");
        }

        for (Invoker<InVO, OutVO> service : services.values()) {
            Invoker<InVO, OutVO> serviceProxy = (Invoker<InVO, OutVO>) AopTargetUtils.getTarget(service);
            Gateway gatewayAnno = serviceProxy.getClass().getDeclaredAnnotation(Gateway.class);
            if (gatewayAnno == null) {
                throw new IllegalStateException("Cannot register Invoker, please make sure place annotation @Gateway on service, serivce: " + service.getClass().getName());

            }
            String serviceName = gatewayAnno.value().getCode();
            Invoker<InVO, OutVO> sps = GATEWAY_SERVICES.get(serviceName);
            if (sps != null) {
                throw new IllegalStateException("Cannot register Invoker, the service name has been register by other gateway service, service: " + service.getClass().getName());
            }
            GATEWAY_SERVICES.put(serviceName, service);
            logger.info("Register OrderCoreProxyService: {} - {}", serviceName, service.getClass().getName());
        }
    }

    /**
     * 系统启动时，注册系统中的网关参数校验器
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void registerValidators() {
        Map<String, Validator> validators = applicationContext.getBeansOfType(Validator.class, false, true);

        if (MapUtils.isEmpty(validators)) {
            throw new IllegalStateException("Cannot register Validator, please make sure the ValidatorUtils setup as spring bean");
        }

        for (Validator<Request> validator : validators.values()) {
            Validator<Request> validatorProxy = (Validator<Request>) AopTargetUtils.getTarget(validator);
            Gateway gatewayAnno = validatorProxy.getClass().getDeclaredAnnotation(Gateway.class);
            if (gatewayAnno == null) {
                throw new IllegalStateException("Cannot register Validator, please make sure place annotation @Gateway on validator, validator: " + validator.getClass().getName());

            }
            String serviceName = gatewayAnno.value().getCode();
            Validator<Request> v = GATEWAY_VALIDATORS.get(serviceName);
            if (v != null) {
                throw new IllegalStateException(
                        "Cannot register Validator, the service name has been register by other gateway validator, validator: " + validator.getClass().getName());
            }
            GATEWAY_VALIDATORS.put(serviceName, validator);
            logger.info("Register Validator: {} - {}", serviceName, validator.getClass().getName());
        }
    }

    /**
     * 系统启动时，注册网关服务数据转换器
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void registerConverters() {
        Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class, false, true);

        if (MapUtils.isEmpty(converters)) {
            throw new IllegalStateException("Cannot register Converter, please make sure the Converter setup as spring bean");
        }

        for (Converter<Request, Response, InVO, OutVO> converter : converters.values()) {
            Converter<Request, Response, InVO, OutVO> converterProxy = (Converter<Request, Response, InVO, OutVO>) AopTargetUtils.getTarget(converter);
            Gateway gatewayAnno = converterProxy.getClass().getDeclaredAnnotation(Gateway.class);
            if (gatewayAnno == null) {
                throw new IllegalStateException("Cannot register Converter, please make sure place annotation @Gateway on converter, converter: " + converter.getClass().getName());

            }
            String serviceName = gatewayAnno.value().getCode();
            Converter<Request, Response, InVO, OutVO> v = GATEWAY_CONVERTERS.get(serviceName);
            if (v != null) {
                throw new IllegalStateException(
                        "Cannot register Converter, the service name has been register by other gateway converter, converter: " + converter.getClass().getName());
            }
            GATEWAY_CONVERTERS.put(serviceName, converter);
            logger.info("Register Converter: {} - {}", serviceName, converter.getClass().getName());
        }
    }

    /**
     * 系统启动时，注册系统中的网关过滤器
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void registerFilters() {
        // Load spring beans type of GatewayFilter
        Map<String, GatewayFilter> filterMap = applicationContext.getBeansOfType(GatewayFilter.class, false, true);

        if (MapUtils.isEmpty(filterMap)) {
            logger.warn("Cannot register GatewayFilter, please make sure the filter setup as spring beans.");
            return;
        }

        // Group filters by type
        for (GatewayFilter<InVO, OutVO> filter : filterMap.values()) {
            if (!GATEWAY_FILTERS.containsKey(filter.filterType())) {
                GATEWAY_FILTERS.put(filter.filterType(), new ArrayList<>());
            }
            List<GatewayFilter<InVO, OutVO>> list = GATEWAY_FILTERS.get(filter.filterType());
            list.add(filter);
            logger.info("Register GatewayFilters: {}", filter.getClass().getName());
        }

        // Order filters
        for (Map.Entry<String, List<GatewayFilter<InVO, OutVO>>> entry : GATEWAY_FILTERS.entrySet()) {
            String key = entry.getKey();
            List<GatewayFilter<InVO, OutVO>> filters = GATEWAY_FILTERS.get(key);
            Collections.sort(filters);
            GATEWAY_FILTERS.put(key, filters);
        }
    }

    /**
     * 系统启动时，注册系统中的格式化器
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void registerFormatters() {
        Map<String, Formatter> formatters = applicationContext.getBeansOfType(Formatter.class, false, true);

        if (MapUtils.isEmpty(formatters)) {
            throw new IllegalStateException("Cannot register Formatter, please make sure the FormatterUtils setup as spring bean");
        }

        for (Formatter<Request, Response, InVO, OutVO> formatter : formatters.values()) {
            Formatter<Request, Response, InVO, OutVO> formatterProxy = (Formatter<Request, Response, InVO, OutVO>) AopTargetUtils.getTarget(formatter);
            Gateway gatewayAnno = formatterProxy.getClass().getDeclaredAnnotation(Gateway.class);
            if (gatewayAnno == null) {
                throw new IllegalStateException("Cannot register Formatter, please make sure place annotation @Gateway on formatter, formatter: " + formatter.getClass().getName());

            }
            String serviceName = gatewayAnno.value().getCode();
            Formatter<Request, Response, InVO, OutVO> v = GATEWAY_FORMATTERS.get(serviceName);
            if (v != null) {
                throw new IllegalStateException(
                        "Cannot register Formatter, the service name has been register by other gateway formatter, formatter: " + formatter.getClass().getName());
            }
            GATEWAY_FORMATTERS.put(serviceName, formatter);
            logger.info("Register Formatter: {} - {}", serviceName, formatter.getClass().getName());
        }
    }

}