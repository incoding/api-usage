package com.javaapi.test.spring.feature.applicationListener;

public class HelloWorld {

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void getMsg() {
        System.out.println("your message:" + msg);
    }

}