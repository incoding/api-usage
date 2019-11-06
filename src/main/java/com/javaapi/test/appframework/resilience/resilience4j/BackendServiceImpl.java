package com.javaapi.test.appframework.resilience.resilience4j;

import com.javaapi.test.buisness.joint.result.base.BaseResult;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2019/11/2
 */
@Service("backendServiceImpl")
public class BackendServiceImpl implements BackendService {
    @Override
    public String doSomething() {
        System.out.println("normal service");
        return "normal service";
    }

    @Override
    public BaseResult<String> normalReturn() {
        System.out.println("execute normal");
        BaseResult<String> result = new BaseResult<>();
        result.setOk(true);
        return result;
    }

    @Override
    public BaseResult<String> exceptionReturn() {
        System.out.println("execute exception");
        if (true) {
            throw new RuntimeException("exception return");
        }
        System.out.println("execute normal");
        BaseResult<String> result = new BaseResult<>();
        result.setOk(true);
        return result;
    }

    @Override
    public BaseResult<String> wrongReturn() {
        System.out.println("execute wrongReturn");
        BaseResult<String> result = new BaseResult<>();
        result.setOk(false);
        result.setCode("10000");
        return result;
    }
}
