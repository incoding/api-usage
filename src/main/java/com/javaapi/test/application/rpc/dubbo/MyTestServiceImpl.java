package com.javaapi.test.application.rpc.dubbo;

public class MyTestServiceImpl implements MyTestService {

    public String sendMessage(String name) {
        return "hello" + name;
    }

}
