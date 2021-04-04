package com.javaapi.test.buisness.pattern.ext.pipeline;


public interface TradePipeline {
    void filter(OrderContext orderContext, PipelineProxy proxy);
}
