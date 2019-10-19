package com.javaapi.test.spring.spring.custom.proxydosomething.custombeanload.customscaner.frame;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 Created by user on 2019/5/3
 这个case 是给接口生成代理,调用接口方法的时候  机型远程http调用
 */
public class AgentProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这里不调用原方法,而是进行httpclient 调用
//        method.invoke(proxy, args);
        String someResult = "this is result";
//        someResult = httpclient.post(method,args);
        return someResult;

    }
}