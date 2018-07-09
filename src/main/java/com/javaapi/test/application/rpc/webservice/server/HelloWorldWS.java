package com.javaapi.test.application.rpc.webservice.server;

/**
 * Created by user on 17/12/23.
 */
public interface HelloWorldWS {
    public HelloResp sayHello(HelloReq helloReq);
}
