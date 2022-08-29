package com.javaapi.test.spring.spring.pattern.templatev2.factory.context;


import com.javaapi.test.spring.spring.pattern.templatev2.factory.enums.ExecutionStatus;

import java.io.Serializable;

/**
 *
 */
public class GatewayFilterResult implements Serializable {
    private static final long serialVersionUID = 5592342849742313254L;
    /**
     * 过滤器返回的过滤结果
     */
    private Object result;
    /**
     * 过滤器执行发生的异常
     */
    private Throwable exception;
    /**
     * 过滤器执行的结果
     */
    private ExecutionStatus status;

    /**
     * 默认构造函数
     */
    public GatewayFilterResult() {
    }

    /**
     * 构造方法
     *
     * @param status
     */
    public GatewayFilterResult(ExecutionStatus status) {
        this.status = status;
    }

    /**
     * 构造方法
     *
     * @param exception
     * @param status
     */
    public GatewayFilterResult(Throwable exception, ExecutionStatus status) {
        this.exception = exception;
        this.status = status;
    }

    /**
     * 构造方法
     *
     * @param result
     * @param status
     */
    public GatewayFilterResult(Object result, ExecutionStatus status) {
        this.result = result;
        this.status = status;
    }

    /**
     * 构造方法
     *
     * @param result
     * @param exception
     * @param status
     */
    public GatewayFilterResult(Object result, Throwable exception, ExecutionStatus status) {
        this.result = result;
        this.exception = exception;
        this.status = status;
    }

    /**
     * 获取执行过滤器结果
     *
     * @return
     */
    public Object getResult() {
        return result;
    }

    /**
     * 设置过滤器执行结果
     *
     * @param result
     * @return
     */
    public GatewayFilterResult setResult(Object result) {
        this.result = result;
        return this;
    }

    /**
     * 获取过滤器执行的异常
     *
     * @return
     */
    public Throwable getException() {
        return exception;
    }

    /**
     * 设置过滤器执行的异常
     *
     * @param exception
     * @return
     */
    public GatewayFilterResult setException(Throwable exception) {
        this.exception = exception;
        return this;
    }

    /**
     * 获取过滤器执行结果装填
     *
     * @return
     */
    public ExecutionStatus getStatus() {
        return status;
    }

    /**
     * 设置过滤器执行结果状态
     *
     * @param status
     * @return
     */
    public GatewayFilterResult setStatus(ExecutionStatus status) {
        this.status = status;
        return this;
    }
}
