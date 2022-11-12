package com.javaapi.test.spring.spring.pattern.pipelinev3.pipeline;

public abstract class AbstractPipeline<T> implements Pipeline<T> {

    @Override
    public void controlExecute(T context, Pipeline<T> proxy) {
        before(context);
        execute(context);
        proxy.controlExecute(context, proxy);
        after(context);
    }

    protected void before(T orderContext) {
    }

    protected abstract void execute(T orderContext);

    protected void after(T orderContext) {

    }

}