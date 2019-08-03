package com.javaapi.test.buisness.pattern.action.interceptor;


public interface Interceptor {

    void init();

    String intercept(ActionInvocation invocation) throws Exception;

    void destroy();
}
