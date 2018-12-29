package com.javaapi.test.buisness.pattern.listener;

import java.util.EventListener;

/**
 * Created by user on 2018/12/27
 */
public interface OrderStatusChangeListener<T> extends EventListener {
    public void change(T event);
}
