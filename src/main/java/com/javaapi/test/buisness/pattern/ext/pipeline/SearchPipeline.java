package com.javaapi.test.buisness.pattern.ext.pipeline;


public class SearchPipeline implements TradePipeline {
    @Override
    public void filter(OrderContext orderContext, PipelineProxy proxy) {
        System.out.println("查询前");
        proxy.filter(orderContext, proxy);
        System.out.println("查询后");
    }
}
