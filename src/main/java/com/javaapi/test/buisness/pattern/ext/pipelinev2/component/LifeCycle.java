package com.javaapi.test.buisness.pattern.ext.pipelinev2.component;

/**
 * 生命周期
 */
public interface LifeCycle {
    /**
     * 初始化
     *
     * @param config
     */
    void init(String config);

    /**
     * 启动
     */
    void startup();

    /**
     * 结束
     */
    void shutdown();
}