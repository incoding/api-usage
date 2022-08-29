package com.javaapi.test.spring.spring.pattern.templatev2.factory.context;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.GatewayMethodEnum;
import org.joda.time.DateTime;
import org.springframework.util.StopWatch;

import java.io.Serializable;

/**
 *
 */
public class GatewayFilterContext<Req extends Serializable, Res extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 请求参数
     */
    private Req request;
    /**
     * 调用返回参数
     */
    private ResponseContext<Res> response;
    /**
     * 过滤器返回值
     */
    private GatewayFilterResult result;
    /**
     * 调用的方法
     */
    private GatewayMethodEnum method;
    /**
     * 上下文创建时间
     */
    private DateTime startTime = DateTime.now();
    /**
     * 计时器
     */
    private StopWatch stopWatch;

    /**
     * 构造方法
     *
     * @param method
     */
    public GatewayFilterContext(GatewayMethodEnum method) {
        this.method = method;
    }

    /**
     * 构造方法
     *
     * @param request
     * @param response
     * @param result
     * @param method
     */
    public GatewayFilterContext(Req request, ResponseContext<Res> response, GatewayFilterResult result, GatewayMethodEnum method) {
        this.request = request;
        this.response = response;
        this.result = result;
        this.method = method;
    }

    /**
     * 构造方法
     *
     * @param request
     * @param method
     */
    public GatewayFilterContext(Req request, GatewayMethodEnum method) {
        this.request = request;
        this.method = method;
    }

    /**
     * 构造方法
     *
     * @param request
     * @param result
     * @param method
     */
    public GatewayFilterContext(Req request, GatewayFilterResult result, GatewayMethodEnum method) {
        this.request = request;
        this.result = result;
        this.method = method;
    }

    /**
     * 获取Response
     *
     * @return
     */
    public ResponseContext<Res> getResponse() {
        return response;
    }

    /**
     * 设置Response
     *
     * @param response
     * @return
     */
    public GatewayFilterContext<Req, Res> setResponse(ResponseContext<Res> response) {
        this.response = response;
        return this;
    }

    /**
     * 获取Request
     *
     * @return
     */
    public Req getRequest() {
        return request;
    }

    /**
     * 设置Request
     *
     * @param request
     * @return
     */
    public GatewayFilterContext<Req, Res> setRequest(Req request) {
        this.request = request;
        return this;
    }

    /**
     * 获取Result
     *
     * @return
     */
    public GatewayFilterResult getResult() {
        return result;
    }

    /**
     * 设置Result
     *
     * @param result
     * @return
     */
    public GatewayFilterContext<Req, Res> setResult(GatewayFilterResult result) {
        this.result = result;
        return this;
    }

    /**
     * 获取Gateway执行方法
     *
     * @return
     */
    public GatewayMethodEnum getMethod() {
        return method;
    }

    /**
     * 设置Gateway执行方法
     *
     * @param method
     * @return
     */
    public GatewayFilterContext<Req, Res> setMethod(GatewayMethodEnum method) {
        this.method = method;
        return this;
    }

    /**
     * @return
     */
    public StopWatch getStopWatch() {
        if (stopWatch == null) {
            this.stopWatch = new StopWatch(method.getCode());
        }
        return stopWatch;
    }

    /**
     * @param stopWatch
     * @return
     */
    public GatewayFilterContext<Req, Res> setStopWatch(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
        return this;
    }

    /**
     * 获取上下文创建时间
     *
     * @return
     */
    public DateTime getStartTime() {
        return startTime;
    }
}
