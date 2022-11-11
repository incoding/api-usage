package com.javaapi.test.buisness.pattern.ext.pipelinev2;

import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Component;
import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Sink;

import java.util.Collection;

/**
 * 控制台
 */
public class ConsoleSink extends Sink<String, Void> {

    @Override
    protected Void doExecute(String o) {
        return null;
    }

    @Override
    public String getName() {
        return "Console-Sink";
    }

    @Override
    public Collection<Component> getDownStrems() {
        return null;
    }

    @Override
    public void init(String config) {

    }
}