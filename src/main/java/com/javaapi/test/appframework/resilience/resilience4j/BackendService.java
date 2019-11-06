package com.javaapi.test.appframework.resilience.resilience4j;

import com.javaapi.test.buisness.joint.result.base.BaseResult;

/**
 * Created by user on 2019/11/2
 */
public interface BackendService {
    String doSomething();

    BaseResult<String> normalReturn();

    BaseResult<String> exceptionReturn();

    BaseResult<String> wrongReturn();
}