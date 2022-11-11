package com.javaapi.test.buisness.pattern.ext.pipelinev2;

import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Component;
import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Source;

import java.util.Collection;
import java.util.Collections;

/**
 * 来源
 */
public class Integer2Source extends Source<Integer, Integer> {

    private int val = 0;

    @Override
    protected Integer doExecute(Integer o) {
        return o + 2;
    }

    @Override
    public void init(String config) {
        System.out.println("--------- " + getName() + " init --------- ");
        val = 1;
    }

    @Override
    public void startup() {
        super.startup();
        execute(val);
    }

    @Override
    public String getName() {
        return "Integer2-Source";
    }

    @Override
    public Collection<Component> getDownStrems() {
        return Collections.singletonList(new IncrChannel());
    }
}