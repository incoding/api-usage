package com.javaapi.test.spring.spring.pattern.pipelinev3;


import com.javaapi.test.spring.spring.pattern.pipelinev3.pipeline.AbstractPipeline;

public class CheckPipeline extends AbstractPipeline<OrderContext> {

    @Override
    protected void before(OrderContext orderContext) {
        System.out.println("限制前");
    }

    @Override
    protected void execute(OrderContext orderContext) {

    }

    @Override
    protected void after(OrderContext orderContext) {
        System.out.println("限制后");
    }

}