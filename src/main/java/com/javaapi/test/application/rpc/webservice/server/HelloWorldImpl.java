package com.javaapi.test.application.rpc.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldImpl implements HelloWorldWS {
    @WebMethod
    @Override
    public HelloResp sayHello(HelloReq helloReq) {
        String str = "欢迎你：" + helloReq.getReq();
        HelloResp helloResp = new HelloResp(str);
        return helloResp;
    }
}