package com.javaapi.test.spring.spring.custom.registry.customlog.handler;

import com.javaapi.test.spring.spring.custom.registry.customlog.aop.CustomLog;

import java.util.List;
import java.util.Map;


public interface CollectHandlerProvider {


    DataCollectHandler queryCollectHandler(CustomLog customLog);

    Map<String, List<String>> getHandlerNameGroupMap();

}
