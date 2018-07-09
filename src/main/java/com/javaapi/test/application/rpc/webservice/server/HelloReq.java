package com.javaapi.test.application.rpc.webservice.server;

import java.io.Serializable;

/**
 * Created by user on 17/12/26.
 */
public class HelloReq implements Serializable{

    private String req;

    public HelloReq() {
    }

    public HelloReq(String req) {
        this.req = req;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }
}
