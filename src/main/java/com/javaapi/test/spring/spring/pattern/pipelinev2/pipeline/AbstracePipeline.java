package com.javaapi.test.spring.spring.pattern.pipelinev2.pipeline;

/**
 * 管道基础类
 */
@Deprecated
public abstract class AbstracePipeline<C> implements TradePipeline<C> {
    @Override
    public void execute(C context, PipelineProxy proxy) {
        beforeExecute(context);
        proxy.execute(context, proxy);
        afterExecute(context);
    }

    private void afterExecute(C context) {

    }

    private void beforeExecute(C context) {

    }
}
