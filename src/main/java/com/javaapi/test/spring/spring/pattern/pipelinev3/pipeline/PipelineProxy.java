package com.javaapi.test.spring.spring.pattern.pipelinev3.pipeline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PipelineProxy<T> implements Pipeline<T> {
    List<Pipeline<T>> list = new ArrayList<>();
    Iterator<Pipeline<T>> iterator = null;

    @Override
    public void controlExecute(T orderContext, Pipeline<T> proxy) {
        PipelineProxy pipelineProxy = (PipelineProxy) proxy;
        if (pipelineProxy.iterator == null) {
            pipelineProxy.iterator = list.iterator();
        }
        while (pipelineProxy.iterator.hasNext()) {
            Pipeline next = iterator.next();
            next.controlExecute(orderContext, proxy);
        }
    }

    public void setPipelines(List<Pipeline<T>> list) {
        this.list = list;
    }
}