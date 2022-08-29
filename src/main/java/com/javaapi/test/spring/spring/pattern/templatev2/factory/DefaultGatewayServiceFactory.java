package com.javaapi.test.spring.spring.pattern.templatev2.factory;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.spring.spring.pattern.template.exception.BaseException;
import com.javaapi.test.spring.spring.pattern.template.exception.BaseRuntimeException;
import com.javaapi.test.spring.spring.pattern.template.util.ThrowableAnalyzer;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.GatewayFilterContext;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.GatewayFilterResult;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.ResponseContext;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.converter.Converter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.enums.ExecutionStatus;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.ConverterException;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.FilterException;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.InvokerException;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.ValidatorException;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.filter.AbstractGatewayFilter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.filter.GatewayFilter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.formatter.Formatter;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.invoker.Invoker;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.registry.GatewayServiceRegister;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.util.LogContextUtils;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.util.LoggerUtils;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.validator.BaseValidator;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.validator.Validator;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseRequestDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseResponseDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Service
public class DefaultGatewayServiceFactory<Request extends BaseRequestDTO, Response extends BaseResponseDTO, InVO extends Serializable, OutVO extends Serializable>
        implements GatewayServiceFactory<Request, Response, InVO, OutVO> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultGatewayServiceFactory.class);

    /**
     * The Throwable analyzer
     */
    private static final ThrowableAnalyzer THROWABLE_ANALYZER = new ThrowableAnalyzer();

    /**
     * 服务网关提供商
     */
    @Resource
    private GatewayServiceRegister<Request, Response, InVO, OutVO> gatewayServiceRegister;

    @Override
    public Response invoke(GatewayMethodEnum gatewayMethod, Request request, Response response) {
        GatewayFilterContext<InVO, OutVO> context = new GatewayFilterContext<>(gatewayMethod);
        context.getStopWatch().start();
        try {
            // 请求参数校验
            doValidation(request, context);
            // 数据转换
            doPreConverter(request, context);
            // 执行前置过滤器
            preFilter(context);
            // 调用服务
            doBusiness(context);
            // 数据转换
            response = doPostConverter(context);
            return response;
        } catch (ValidatorException e) {
            LoggerUtils.warn(logger, "[{}]参数验证异常,详情:{}", e, LogContextUtils.getModule(), "验证异常：" + e.getMessage());
            return getResDTOFromException(context, response, "验证异常：" + e.getErrorMsg(), e);
        } catch (ConverterException e) {
            LoggerUtils.warn(logger, "[{}]数据转换异常,详情:{}", e, LogContextUtils.getModule(), "转换异常：" + e.getMessage());
            return getResDTOFromException(context, response, "转换异常：" + e.getErrorMsg(), e);
        } catch (InvokerException e) {
            LoggerUtils.warn(logger, "[{}]业务处理异常,详情:{}", e, LogContextUtils.getModule(), "业务异常：" + e.getMessage());
            return getResDTOFromException(context, response, "业务异常：" + e.getErrorMsg(), e);
        } catch (Exception e) {
            LoggerUtils.error(logger, "[{}]系统异常,详情:{}", e, LogContextUtils.getModule(), "未知异常：" + e.getMessage());
            return getResDTOFromException(context, response, "未知异常：" + e.getMessage(), e);
        } finally {
            response.setTraceId(request.getTraceId());
            // 执行后置过滤器
            postFilter(context);
            if (context.getStopWatch().isRunning()) {
                context.getStopWatch().stop();
            }
            //扫尾处理respose
            dealFormatter(request, response, context);
            LoggerUtils.info(logger, "[服务网关]详情:{}", context.getStopWatch().prettyPrint());
            LogContextUtils.removeCategory();
            LogContextUtils.removeSubCategory();
        }
    }

    /**
     * 数据校验、业务逻辑校验
     *
     * @param request
     * @param context
     * @throws ValidatorException
     */
    private void doValidation(Request request, GatewayFilterContext<InVO, OutVO> context) throws ValidatorException {
        String serviceName = context.getMethod().getCode();
        Validator<Request> validator = gatewayServiceRegister.retrieveValidator(serviceName);
        if (validator == null) {
            throw new IllegalArgumentException("[Service is invalid] cannot found Validator for service: " + serviceName);
        }
        startStopWatch(context.getStopWatch(), "validate");
        if (validator instanceof BaseValidator) {
            BaseValidator bv = (BaseValidator) validator;
            bv.baseValidate(request);
        }
        validator.validate(request);
        context.getStopWatch().stop();
    }

    /**
     * 入参转换
     *
     * @param request
     * @param context
     * @return
     * @throws ConverterException
     */
    private InVO doPreConverter(Request request, GatewayFilterContext<InVO, OutVO> context) throws ConverterException, IllegalAccessException {
        String serviceName = context.getMethod().getCode();
        Converter<Request, Response, InVO, OutVO> converter = gatewayServiceRegister.retrieveConverter(serviceName);
        if (converter == null) {
            throw new IllegalArgumentException("[Service is invalid] cannot found Converter for service: " + serviceName);
        }
        startStopWatch(context.getStopWatch(), "preConverter");
        InVO inVO = converter.requestToVO(request);
        context.setRequest(inVO);
        context.getStopWatch().stop();
        return inVO;
    }

    /**
     * 出参转换
     *
     * @param context
     * @return
     * @throws ConverterException
     */
    private Response doPostConverter(GatewayFilterContext<InVO, OutVO> context) throws ConverterException {
        String serviceName = context.getMethod().getCode();
        Converter<Request, Response, InVO, OutVO> converter = gatewayServiceRegister.retrieveConverter(serviceName);
        if (converter == null) {
            throw new IllegalArgumentException("[Service is invalid] cannot found Converter for service: " + serviceName);
        }

        startStopWatch(context.getStopWatch(), "postConverter");
        Response response = converter.voToResponse(context.getResponse());
        context.getStopWatch().stop();
        return response;
    }

    /**
     * 执行前置业务逻辑过滤器
     *
     * @param context the context
     */
    private void preFilter(GatewayFilterContext<InVO, OutVO> context) {
        List<GatewayFilter<InVO, OutVO>> preFilters = gatewayServiceRegister.findFiltersByType(AbstractGatewayFilter.FILTER_TYPE_PRE);
        if (CollectionUtils.isEmpty(preFilters)) {
            return;
        }

        for (GatewayFilter<InVO, OutVO> filter : preFilters) {
            try {
                startStopWatch(context.getStopWatch(), filter.getClass().getName());
                filter.filter(context);
            } catch (FilterException e) {
                LoggerUtils.error(logger, "Execute pre filter fail.", e);
            } catch (Exception e) {
                LoggerUtils.error(logger, "Execute pre filter unknown fail.", e);
            } finally {
                context.getStopWatch().stop();
            }
        }
    }

    /**
     * Post filter.
     *
     * @param context the context
     */
    private void postFilter(GatewayFilterContext<InVO, OutVO> context) {
        List<GatewayFilter<InVO, OutVO>> postFilters = gatewayServiceRegister.findFiltersByType(AbstractGatewayFilter.FILTER_TYPE_POST);
        if (CollectionUtils.isEmpty(postFilters)) {
            return;
        }

        GatewayFilterResult filterResult = null;
        for (GatewayFilter<InVO, OutVO> filter : postFilters) {
            startStopWatch(context.getStopWatch(), filter.getClass().getName());
            try {
                Object result = filter.filter(context);
                filterResult = new GatewayFilterResult(result, ExecutionStatus.SUCCESS);
            } catch (FilterException e) {
                LoggerUtils.error(logger, "Execute post filter fail. Context: {}", JSON.toJSONString(context), e);
                filterResult = new GatewayFilterResult(e, ExecutionStatus.FAILED);
            } catch (Exception e) {
                LoggerUtils.error(logger, "Execute post filter unknown fail. Context: {}", JSON.toJSONString(context), e);
                filterResult = new GatewayFilterResult(e, ExecutionStatus.FAILED);
            } finally {
                context.getStopWatch().stop();
                context.setResult(filterResult);
            }
        }
    }

    /**
     * 扫尾工作
     *
     * @param request
     * @param response
     * @param context
     */
    private void dealFormatter(Request request, Response response, GatewayFilterContext<InVO, OutVO> context) {
        String serviceName = context.getMethod().getCode();
        Formatter<Request, Response, InVO, OutVO> formatter = gatewayServiceRegister.retrieveFormatter(serviceName);
        if (formatter == null) {
            return;
        }
        startStopWatch(context.getStopWatch(), "formatter");
        formatter.dealResponse(request, response, context);
        context.getStopWatch().stop();
    }

    /**
     * 执行业务逻辑
     *
     * @param context
     * @return //     * @throws BaseOrderCoreInterfaceException
     */
    private ResponseContext<OutVO> doBusiness(GatewayFilterContext<InVO, OutVO> context) throws InvokerException {
        String serviceName = context.getMethod().getCode();
        Invoker<InVO, OutVO> service = gatewayServiceRegister.retrieveProxyService(serviceName);
        if (service == null) {
            throw new IllegalArgumentException("[Service is invalid] cannot found GWSaleProxyService for service: " + serviceName);
        }
        startStopWatch(context.getStopWatch(), "business");
        ResponseContext<OutVO> responseCtx = service.invoke(context.getRequest());
        context.setResponse(responseCtx);
        context.getStopWatch().stop();
        return responseCtx;
    }

    /**
     * Start stop watch.
     *
     * @param stopWatch the stop watch
     * @param name      the name
     */
    private void startStopWatch(StopWatch stopWatch, String name) {
        if (stopWatch.isRunning()) {
            stopWatch.stop();
        }
        stopWatch.start(name);
    }

    /**
     * @param context  the context
     * @param response the res dto
     * @param message  the message
     * @param e        the e
     */
    private Response getResDTOFromException(GatewayFilterContext<InVO, OutVO> context, Response response, String message, Exception e) {
        getErrorMsg(response, e, message);
        ResponseContext<OutVO> result = new ResponseContext<>();
        result.setSuccess(false);
        result.setMessage(StringUtils.defaultIfBlank(response.getErrorMessage(), "系统异常"));
        result.setCode(StringUtils.defaultIfBlank(response.getErrorCode(), "XX0500000000"));
        result.setErrorMsg(StringUtils.defaultIfBlank(message, "系统异常"));
        context.setResponse(result);
        return response;
    }

    /**
     * Gets error msg.
     *
     * @param response
     * @param e
     * @return the error msg
     */
    private Response getErrorMsg(Response response, Exception e, String message) {
        Throwable[] causeChain = THROWABLE_ANALYZER.determineCauseChain(e);
        BaseException lye = (BaseException) THROWABLE_ANALYZER.getFirstThrowableOfType(BaseException.class, causeChain);
        BaseRuntimeException lyre = (BaseRuntimeException) THROWABLE_ANALYZER.getFirstThrowableOfType(BaseRuntimeException.class, causeChain);
        String code = "XX000000001";
        String msg;
        if (lye != null) {
            msg = lye.getMessage();
            code = lye.getErrorCode();
        } else if (lyre != null) {
            msg = lyre.getMessage();
            code = lyre.getErrorCode();
        } else if (StringUtils.isNotBlank(e.getMessage())) {
            msg = e.getMessage();
        } else {
            msg = "系统异常, 异常类型: " + e.getClass().getName();
        }
        response.setSuccess(false);
        response.setErrorMessage(StringUtils.isBlank(message) ? msg : message);
        response.setErrorCode(code);
        return response;
    }

}
