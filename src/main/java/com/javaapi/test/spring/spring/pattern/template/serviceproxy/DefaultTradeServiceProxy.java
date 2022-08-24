
package com.javaapi.test.spring.spring.pattern.template.serviceproxy;

import com.javaapi.test.spring.spring.pattern.template.converter.request.RequestConverter;
import com.javaapi.test.spring.spring.pattern.template.converter.response.ResponseConverter;
import com.javaapi.test.spring.spring.pattern.template.core.TradeResponse;
import com.javaapi.test.spring.spring.pattern.template.core.TradeServiceEnum;
import com.javaapi.test.spring.spring.pattern.template.core.TradeServiceInvoker;
import com.javaapi.test.spring.spring.pattern.template.enums.OrderSourceEnum;
import com.javaapi.test.spring.spring.pattern.template.enums.ResourceTypeEnum;
import com.javaapi.test.spring.spring.pattern.template.exception.*;
import com.javaapi.test.spring.spring.pattern.template.util.ThrowableAnalyzer;
import com.javaapi.test.spring.spring.pattern.template.util.TradeUtils;
import com.javaapi.test.spring.spring.pattern.template.validator.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 *
 */
@Service
public class DefaultTradeServiceProxy<Request extends Serializable, Response extends Serializable, InnerRequest extends Serializable, InnerResponse extends Serializable> implements TradeServiceProxy<Request, Response> {

    /**
     * The Throwable analyzer
     */
    private static final ThrowableAnalyzer THROWABLE_ANALYZER = new ThrowableAnalyzer();

    /**
     * 服务网关实现提供
     */
    @Resource(name = "tradeServiceProvider")
    private TradeServiceProvider<Request, Response, InnerRequest, InnerResponse> tradeServiceProvider;

    /**
     *
     */
    @Override
    public Response invoke(Request request, TradeServiceEnum service, ResourceTypeEnum resourceType, OrderSourceEnum source) throws APIException {
        baseValidate(request, service);
        try {

            validate(request, service);

            TradeResponse<Response> tradeResponse = execute(request, service, resourceType, source);

            return tradeResponse.getData();
        } catch (ValidationException e) {
            throw resolveErrorResponse(e.getTraceId(), "[Trade Validation Error] " + e.getMessage(), e);
        } catch (TradeServiceException e) {
            throw resolveErrorResponse(e.getTraceId(), "[Trade Biz Error] " + e.getMessage(), e);
        } catch (Exception e) {
            throw resolveErrorResponse("", "[Trade Unknown Error] " + e.getMessage(), e);
        }
    }

    /**
     * Execute business logic
     *
     * @param service
     * @param resourceType
     * @return
     * @throws TradeServiceException
     */
    protected TradeResponse<Response> execute(Request request, TradeServiceEnum service, ResourceTypeEnum resourceType, OrderSourceEnum source) throws TradeServiceException {
        String serviceId = TradeUtils.resolveTradeServiceId(service, resourceType, source);

        TradeServiceInvoker<InnerRequest, InnerResponse> serviceInvoker = tradeServiceProvider.retrieveTradeService(serviceId);
        if (serviceInvoker == null) {
            throw new IllegalArgumentException("[Service is invalid] cannot found TradeServiceInvoker for service: " + serviceId);
        }
        InnerRequest innerRequest = converterRequest(request, service);

        TradeResponse<InnerResponse> tradeInnerResponse = serviceInvoker.invoke(innerRequest);
        if (tradeInnerResponse == null) {
            throw new IllegalStateException("API Response cannot be null: " + serviceId);
        }
        InnerResponse innerResponse = tradeInnerResponse.getData();
        Response response = converterResponse(innerResponse, service);

        TradeResponse<Response> tradeResponse = new TradeResponse<>();
        tradeResponse.setData(response);
        return tradeResponse;
    }

    /**
     * Business validation
     *
     * @param request
     * @param service
     * @throws ValidationException
     */
    @SuppressWarnings("unchecked")
    protected InnerRequest converterRequest(Request request, TradeServiceEnum service) {
        String serviceId = service.getCode();
        RequestConverter<Request, InnerRequest> converter = tradeServiceProvider.retrieveRequestConverter(serviceId);
        if (converter == null) {
            return (InnerRequest) request;
        }
        return converter.converter(request);
    }

    /**
     * Business validation
     *
     * @param innerResponse
     * @param service
     * @throws ValidationException
     */
    @SuppressWarnings("unchecked")
    protected Response converterResponse(InnerResponse innerResponse, TradeServiceEnum service) {
        String serviceId = service.getCode();
        ResponseConverter<Response, InnerResponse> converter = tradeServiceProvider.retrieveResponseConverter(serviceId);
        if (converter == null) {
            return (Response) innerResponse;
        }
        return converter.converter(innerResponse);
    }

    /**
     * Business validation
     *
     * @param request
     * @param service
     * @throws ValidationException
     */
    protected void validate(Request request, TradeServiceEnum service) throws ValidationException {
        String serviceId = service.getCode();
        Validator<Request> validator = tradeServiceProvider.retrieveValidator(serviceId);
        if (validator == null) {
            return;
        }
        validator.validate(request);
    }

    /**
     * 基础校验
     *
     * @param request
     */
    private void baseValidate(Request request, TradeServiceEnum service) {
        if (service == null) {
            throw new IllegalArgumentException("TradeServiceEnum cannot be null");
        }
        if (request == null) {
            throw new IllegalArgumentException("Gateway service request cannot be null");
        }
    }

    /**
     * @param traceId traceId
     * @param message error message
     * @param e       error
     * @return Error response
     */
    private APIException resolveErrorResponse(String traceId, String message, Exception e) {
        Throwable[] causeChain = THROWABLE_ANALYZER.determineCauseChain(e);
        BaseException checkException = (BaseException) THROWABLE_ANALYZER.getFirstThrowableOfType(BaseException.class, causeChain);
        BaseRuntimeException unCheckException = (BaseRuntimeException) THROWABLE_ANALYZER.getFirstThrowableOfType(BaseRuntimeException.class, causeChain);
        String code = "-1";
        String msg;
        if (checkException != null) {
            msg = checkException.getMessage();
            code = checkException.getErrorCode();
        } else if (unCheckException != null) {
            msg = unCheckException.getMessage();
            code = unCheckException.getErrorCode();
        } else if (StringUtils.isNotBlank(e.getMessage())) {
            msg = e.getMessage();
        } else {
            msg = "系统异常, 异常类型: " + e.getClass().getName();
        }
        return APIException.createAPIException(traceId, code, msg, e);
    }

}
