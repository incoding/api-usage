package com.javaapi.test.application.rpc.webservice.server;

import java.io.Serializable;

/**
 * Created by user on 17/12/26.
 */
public class HelloResp implements Serializable{

    private String resp;

    public HelloResp() {
    }

    public HelloResp(String resp) {
        this.resp = resp;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }
}
