package com.javaapi.test.buisness.pattern.ext.pipelinev2;

import com.google.common.collect.Lists;
import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Component;
import com.javaapi.test.buisness.pattern.ext.pipelinev2.component.Source;

import java.util.Collection;
import java.util.Collections;

/**
 * 来源
 */
public class IntegerSource extends Source<Integer, Integer> {

    private int val = 0;

    @Override
    protected Integer doExecute(Integer o) {
        return o;
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
        return "Integer-Source";
    }

    @Override
    public Collection<Component> getDownStrems() {
        return Lists.newArrayList(new Integer2Source(), new IncrChannel());
    }
}