package com.javaapi.test.buisness.result.experiment;

/**
 * Created by user on 2019/3/2
 */
public class BaseInfo<P> {

    private String traceId;

    private P param;

    public BaseInfo(P param) {
        this.param = param;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public P getParam() {
        return param;
    }

    public void setParam(P param) {
        this.param = param;
    }
}
