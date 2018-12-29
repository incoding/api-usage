package com.javaapi.test.buisness.pattern.listener;

import java.util.EventObject;

/**
 * Created by user on 2018/12/27
 */
public class OrderStatusEvent<T> extends EventObject {
    public OrderStatusEvent(T source) {
        super(source);
    }

    @Override
    public T getSource() {
        return (T) source;
    }


}
