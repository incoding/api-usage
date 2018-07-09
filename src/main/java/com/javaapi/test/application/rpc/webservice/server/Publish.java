package com.javaapi.test.application.rpc.webservice.server;


import javax.xml.ws.Endpoint;

/**
 * https://www.cnblogs.com/linxiaoyang/p/4167016.html
 */
public class Publish {
    public static void main(String args[]) {
        Object implementor = new HelloWorldImpl();
        //发布到的地址 http://localhost:8989/HelloWorld?wsdl
        String address = "http://localhost:8989/HelloWorld";
        Endpoint.publish(address, implementor);
        System.out.println("发布成功");
    }
}