package com.javaapi.test.spring.spring.custom.registry.exceptionhandler;

import com.google.common.collect.Maps;
import com.javaapi.test.spring.spring.custom.registry.exceptionhandler.handler.ExceptionHandler;
import com.javaapi.test.spring.spring.custom.registry.exceptionhandler.model.ExceptionContext;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
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


    public void handle(ExceptionContext context) {
        List<ExceptionHandler> exceptionHandlers = getHandlers().get(context.getCode());
        if (CollectionUtils.isEmpty(exceptionHandlers)) {
            return;
        }
        for (ExceptionHandler exceptionHandler : exceptionHandlers) {
            exceptionHandler.handle(context);
        }

    }

    public Map<String, List<ExceptionHandler>> getHandlers() {
        return HANDLERS;
    }
}
