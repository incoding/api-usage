package com.javaapi.test.spring.spring.pattern.pipelinev2.pipeline;


@Deprecated
public interface TradePipeline<C> {
    void execute(C context, PipelineProxy proxy);
}
