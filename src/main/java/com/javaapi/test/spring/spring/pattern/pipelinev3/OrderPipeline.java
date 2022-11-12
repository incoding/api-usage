package com.javaapi.test.spring.spring.pattern.pipelinev3;

import com.javaapi.test.spring.spring.pattern.pipelinev3.pipeline.AbstractPipeline;

public class OrderPipeline extends AbstractPipeline<OrderContext> {

    @Override
    protected void before(OrderContext orderContext) {
        System.out.println("查询前");
    }

    @Override
    protected void execute(OrderContext orderContext) {
        System.out.println("查询");

    }

    @Override
    protected void after(OrderContext orderContext) {
        System.out.println("查询后");
    }

}