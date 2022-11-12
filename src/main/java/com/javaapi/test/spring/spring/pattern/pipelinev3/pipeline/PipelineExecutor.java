package com.javaapi.test.spring.spring.pattern.pipelinev3.pipeline;


import java.util.ArrayList;
import java.util.List;

public class PipelineExecutor<T> {

    List<Pipeline<T>> pipelines = new ArrayList<>();

    public void doPipeline(T context) {
        PipelineProxy<T> proxy = new PipelineProxy<>();
        proxy.setPipelines(pipelines);
        proxy.controlExecute(context, proxy);
    }

    public List<Pipeline<T>> getPipelines() {
        return pipelines;
    }

    public void setPipelines(List<Pipeline<T>> pipelines) {
        this.pipelines = pipelines;
    }
}
