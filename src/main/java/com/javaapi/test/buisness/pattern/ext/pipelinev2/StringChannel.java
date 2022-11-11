package com.javaapi.test.buisness.pattern.ext.pipelinev2;

import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Channel;
import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * 处理：转为字符串
 */
public class StringChannel extends Channel<Integer, String> {

    @Override
    protected String doExecute(Integer o) {
        return "str" + o;
    }

    @Override
    public String getName() {
        return "String-Channel";
    }

    @Override
    public Collection<Component> getDownStrems() {
        return Collections.singletonList(new ConsoleSink());
    }

    @Override
    public void init(String config) {

    }
}