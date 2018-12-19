package com.javaapi.test.test.proxy.testDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("事务开始");
        Object result = method.invoke(target, args);
        System.out.println("事务结束");
        return result;
    }

}