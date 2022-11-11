package com.javaapi.test.buisness.pattern.ext.pipelinev2.component;

import java.util.Collection;

/**
 * 组件
 */
public interface Component<T> extends LifeCycle {
    /**
     * 组件名称
     *
     * @return
     */
    String getName();

    /**
     * 获取下游组件
     *
     * @return
     */
    Collection<Component> getDownStrems();

    /**
     * 执行
     */
    void execute(T o);
}