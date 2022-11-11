package com.javaapi.test.buisness.pattern.ext.pipelinev2;

import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Channel;
import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * 处理：数字+1
 */
public class IncrChannel extends Channel<Integer, Integer> {

    @Override
    protected Integer doExecute(Integer o) {
        return o + 1;
    }

    @Override
    public String getName() {
        return "Incr-Channel";
    }

    @Override
    public Collection<Component> getDownStrems() {
        return Collections.singletonList(new StringChannel());
    }

    @Override
    public void init(String config) {

    }
}