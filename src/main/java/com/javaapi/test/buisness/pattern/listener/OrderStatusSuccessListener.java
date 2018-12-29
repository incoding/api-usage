package com.javaapi.test.buisness.pattern.listener;

/**
 * Created by user on 2018/12/28
 */
public class OrderStatusSuccessListener<T> implements OrderStatusChangeListener<T> {
    @Override
    public void change(T event) {
        if (!(event instanceof OrderStatusEvent)) {
            return;
        }
    }
}
