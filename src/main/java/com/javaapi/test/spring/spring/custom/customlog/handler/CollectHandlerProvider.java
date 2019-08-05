package com.javaapi.test.spring.spring.custom.customlog.handler;

import com.javaapi.test.spring.spring.custom.customlog.aop.CustomLog;

import java.util.List;
import java.util.Map;


public interface CollectHandlerProvider {


    DataCollectHandler queryCollectHandler(CustomLog customLog);

    Map<String, List<String>> getHandlerNameGroupMap();

}
