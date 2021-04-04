package com.javaapi.test.buisness.pattern.ext.pipeline;


public class LimiterPipeline implements TradePipeline {
    @Override
    public void filter(OrderContext orderContext, PipelineProxy proxy) {
        System.out.println("限制前");
        proxy.filter(orderContext, proxy);
        System.out.println("限制后");
    }
}
