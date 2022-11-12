package com.javaapi.test.spring.spring.pattern.pipelinev3.pipeline;

public interface Pipeline<T> {

    void controlExecute(T orderContext, Pipeline<T> proxy);

}
