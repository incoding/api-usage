package com.javaapi.test.application.rpc.dubbo.facadeImpl;

import com.javaapi.test.application.rpc.dubbo.facade.MyTestService;

public class MyTestServiceImpl implements MyTestService {

    @Override
    public String sendMessage(String name) {
        return "hello" + name;
    }

}
