package com.javaapi.test.spring.spring.custom.registry.exceptionresolver;

/**
 * 异常处理器
 */
public interface ExceptionResolver {

    /**
     * 处理具体异常
     *
     * @return
     */
    public Object handle();

    /**
     * 异常处理顺序
     *
     * @return
     */
    public Integer getOrder();
}
