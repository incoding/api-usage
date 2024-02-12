package com.javaapi.test.spring.spring.pattern.statemachinecolacup;

/**
 * 流转执行器
 * @param <P>
 * @param <R>
 */
@SuppressWarnings("all")
public interface TransitExecutor<P extends TransitInfoListener,R> {
    R execute(P p);
}
