
package com.javaapi.test.spring.spring.pattern.template.serviceproxy;

import com.google.common.collect.Maps;
import com.javaapi.test.spring.spring.pattern.template.converter.request.RequestConverter;
import com.javaapi.test.spring.spring.pattern.template.converter.response.ResponseConverter;
import com.javaapi.test.spring.spring.pattern.template.core.TradeService;
import com.javaapi.test.spring.spring.pattern.template.core.TradeServiceInvoker;
import com.javaapi.test.spring.spring.pattern.template.util.TradeUtils;
import com.javaapi.test.spring.spring.pattern.template.validator.Validator;
import com.javaapi.test.spring.spring.util.AopTargetUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Map;

/**
 *
 */
@Service("tradeServiceProvider")
public class DefaultTradeServiceProvider<Request extends Serializable, Response extends Serializable, InnerRequest extends Serializable, InnerResponse extends Serializable>
        implements TradeServiceProvider<Request, Response, InnerRequest, InnerResponse>, InitializingBean {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DefaultTradeServiceProvider.class);
    /**
     * 网关服务集合
     */
    private final Map<String, TradeServiceInvoker<InnerRequest, InnerResponse>> TRADE_SERVICE_INVOKES = Maps.newConcurrentMap();
    /**
     * 数据校验器集合
     */
    private final Map<String, Validator<Request>> TRADE_SERVICE_VALIDATORS = Maps.newConcurrentMap();
    /**
     * 请求参数
     */
    private final Map<String, RequestConverter<Request, InnerRequest>> TRADE_SERVICE_REQUEST_CONVERTERS = Maps.newConcurrentMap();
    /**
     * 响应结果转化器
     */
    private final Map<String, ResponseConverter<Response, InnerResponse>> TRADE_SERVICE_RESPONSE_CONVERTERS = Maps.newConcurrentMap();
    /**
     * spring上下文
     */
    @Resource
    private ApplicationContext applicationContext;


    @Override
    public void afterPropertiesSet() throws Exception {
        // 注册API服务
        registerTradeServiceInvokers();
        // 注册API服务校验器
        registerValidators();
        //注册转化器
        registerRequestConverters();
        registerResponseConverters();
    }


    /**
     * @see TradeServiceProvider#retrieveValidator(String)
     */
    @Override
    public Validator<Request> retrieveValidator(String serviceId) {
        return TRADE_SERVICE_VALIDATORS.get(serviceId);
    }

    /**
     * @see TradeServiceProvider#retrieveTradeService(String)
     */
    @Override
    public TradeServiceInvoker<InnerRequest, InnerResponse> retrieveTradeService(String serviceId) {
        return TRADE_SERVICE_INVOKES.get(serviceId);
    }

    @Override
    public RequestConverter<Request, InnerRequest> retrieveRequestConverter(String serviceId) {
        return TRADE_SERVICE_REQUEST_CONVERTERS.get(serviceId);
    }

    @Override
    public ResponseConverter<Response, InnerResponse> retrieveResponseConverter(String serviceId) {
        return TRADE_SERVICE_RESPONSE_CONVERTERS.get(serviceId);
    }
    // ~ protected方法 ----------------------------------------------------------------------------------------------------------------

    /**
     * 系统启动时，注册系统中的API服务
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected void registerTradeServiceInvokers() {
        Map<String, TradeServiceInvoker> invokers = applicationContext.getBeansOfType(TradeServiceInvoker.class, false, true);

        if (MapUtils.isEmpty(invokers)) {
            throw new IllegalStateException("Cannot register TradeServiceInvoker, please make sure the TradeServiceInvoker setup as spring bean");
        }

        for (TradeServiceInvoker<InnerRequest, InnerResponse> invoker : invokers.values()) {
            TradeServiceInvoker<InnerRequest, InnerResponse> proxy = (TradeServiceInvoker<InnerRequest, InnerResponse>) AopTargetUtils.getTarget(invoker);
            TradeService anno = proxy.getClass().getDeclaredAnnotation(TradeService.class);
            if (anno == null) {
                throw new IllegalStateException("Cannot register TradeServiceInvoker, please make sure place annotation @TradeService on serivce: " + invoker.getClass().getName());

            }
            String serviceId = TradeUtils.resolveTradeServiceId(anno);
            TradeServiceInvoker<InnerRequest, InnerResponse> tsi = TRADE_SERVICE_INVOKES.get(serviceId);
            if (tsi != null) {
                throw new IllegalStateException(
                        "Cannot register TradeServiceInvoker, the service name has been register by other trade service, service: " + invoker.getClass().getName());
            }
            TRADE_SERVICE_INVOKES.put(serviceId, invoker);
            logger.info("Register TradeServiceInvoker: {} - {}", serviceId, invoker.getClass().getName());
        }
    }

    /**
     * 系统启动时，注册系统中的API参数校验器
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void registerValidators() {
        Map<String, Validator> validators = applicationContext.getBeansOfType(Validator.class, false, true);

        if (MapUtils.isEmpty(validators)) {
            logger.info("No validator cannot be Registered, it is not defined");
            return;
        }

        for (Validator<Request> validator : validators.values()) {
            Validator<Request> proxy = (Validator<Request>) AopTargetUtils.getTarget(validator);
            TradeService anno = proxy.getClass().getDeclaredAnnotation(TradeService.class);
            if (anno == null) {
                throw new IllegalStateException("Cannot register Validator, please make sure place annotation @TradeService on validator: " + validator.getClass().getName());

            }
            String serviceId = anno.name().getCode();
            Validator<Request> v = TRADE_SERVICE_VALIDATORS.get(serviceId);
            if (v != null) {
                throw new IllegalStateException(
                        "Cannot register Validator, the service name has been register by other TradeService validator, validator: " + validator.getClass().getName());
            }
            TRADE_SERVICE_VALIDATORS.put(serviceId, validator);
            logger.info("Register Validator: {} - {}", serviceId, validator.getClass().getName());
        }
    }

    /**
     * 系统启动时，注册系统中的API参数校验器
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void registerRequestConverters() {
        Map<String, RequestConverter> converters = applicationContext.getBeansOfType(RequestConverter.class, false, true);

        if (MapUtils.isEmpty(converters)) {
            logger.info("No converter cannot be Registered, it is not defined");
            return;
        }

        for (RequestConverter<Request, InnerRequest> converter : converters.values()) {
            RequestConverter<Request, InnerRequest> proxy = (RequestConverter<Request, InnerRequest>) AopTargetUtils.getTarget(converter);
            TradeService anno = proxy.getClass().getDeclaredAnnotation(TradeService.class);
            if (anno == null) {
                throw new IllegalStateException("Cannot register converter, please make sure place annotation @TradeService on converter: " + converter.getClass().getName());

            }
            String serviceId = anno.name().getCode();
            RequestConverter<Request, InnerRequest> v = TRADE_SERVICE_REQUEST_CONVERTERS.get(serviceId);
            if (v != null) {
                throw new IllegalStateException(
                        "Cannot register converter, the service name has been register by other TradeService converter, converter: " + converter.getClass().getName());
            }
            TRADE_SERVICE_REQUEST_CONVERTERS.put(serviceId, converter);
            logger.info("Register converter: {} - {}", serviceId, converter.getClass().getName());
        }
    }

    /**
     * 系统启动时，注册系统中的API参数校验器
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void registerResponseConverters() {
        Map<String, ResponseConverter> converters = applicationContext.getBeansOfType(ResponseConverter.class, false, true);
        if (MapUtils.isEmpty(converters)) {
            logger.info("No converter cannot be Registered, it is not defined");
            return;
        }
        for (ResponseConverter<Response, InnerResponse> converter : converters.values()) {
            ResponseConverter<Response, InnerResponse> proxy = (ResponseConverter<Response, InnerResponse>) AopTargetUtils.getTarget(converter);
            TradeService anno = proxy.getClass().getDeclaredAnnotation(TradeService.class);
            if (anno == null) {
                throw new IllegalStateException("Cannot register converter, please make sure place annotation @TradeService on converter: " + converter.getClass().getName());

            }
            String serviceId = anno.name().getCode();
            ResponseConverter<Response, InnerResponse> v = TRADE_SERVICE_RESPONSE_CONVERTERS.get(serviceId);
            if (v != null) {
                throw new IllegalStateException(
                        "Cannot register converter, the service name has been register by other TradeService converter, converter: " + converter.getClass().getName());
            }
            TRADE_SERVICE_RESPONSE_CONVERTERS.put(serviceId, converter);
            logger.info("Register converter: {} - {}", serviceId, converter.getClass().getName());
        }
    }

}
