package com.javaapi.test.buisness.pattern.ext.pipeline;


public class Client {
    public static void main(String[] args) {
        PipelineProxy pipelineProxy = new PipelineProxy();
        pipelineProxy.addPipeline(new SearchPipeline());
        pipelineProxy.addPipeline(new LimiterPipeline());
        pipelineProxy.filter(new OrderContext(), pipelineProxy);
    }
}
