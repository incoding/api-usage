package com.javaapi.test.spring.custom.registry.exceptionhandler;

import com.google.common.collect.Maps;
import com.javaapi.test.buisness.joint.exception.BusinessException;
import com.javaapi.test.spring.custom.registry.exceptionhandler.handler.ExceptionHandler;
import com.javaapi.test.spring.custom.registry.exceptionhandler.handler.constants.ExceptionHandlerConstants;
import com.javaapi.test.spring.custom.registry.exceptionhandler.model.ExceptionContext;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by user on 2019/10/19
 */
@Component
public class ExceptionExecutor implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 存放错误码处理器
     */
    private static final Map<String, List<ExceptionHandler>> HANDLERS = Maps.newConcurrentMap();


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ExceptionHandler> beansOfType = applicationContext.getBeansOfType(ExceptionHandler.class, false, true);
        if (MapUtils.isEmpty(beansOfType)) {
            return;
        }
        // value 按order 从小到大排序,order 没赋值,默认Integer.MAX
        // 然后分组
        Map<String, List<ExceptionHandler>> collect = beansOfType.values().stream().sorted(Comparator.comparingInt(value1 -> value1.getOrder() == null ? Integer.MAX_VALUE : value1.getOrder())).collect(Collectors.groupingBy(o -> o.getCode(), Collectors.toList()));
        getHandlers().putAll(collect);
    }

    public void handle(BusinessException exception) {
        ExceptionContext context = new ExceptionContext(exception);
        handle(context);
    }

    public void handle(ExceptionContext context) {
        List<ExceptionHandler> exceptionHandlers = getHandlers().get(context.getCode());
        if (CollectionUtils.isEmpty(exceptionHandlers)) {
            exceptionHandlers = getHandlers().get(ExceptionHandlerConstants.EXCEPTION_DEFAULT_HANDLER);
        }
        for (ExceptionHandler exceptionHandler : exceptionHandlers) {
            exceptionHandler.handle(context);
            if (!context.getNeedContinue()) {
                return;
            }
        }
    }

    private Map<String, List<ExceptionHandler>> getHandlers() {
        return HANDLERS;
    }
}
