package com.javaapi.test.buisness.pattern.ext.listener;

import com.javaapi.test.test.javafeature.version5.generictype.gengericinterface.FruitGenerator;

/**
 * @see FruitGenerator
 * Created by user on 2018/12/28
 */
public class OrderStatusSuccessListener<T> implements OrderStatusChangeListener<T> {
    @Override
    public void change(T event) {
        if (!(event instanceof OrderStatusEvent)) {
            System.out.println("不是 OrderStatusEvent = " + event);
            return;
        }
        System.out.println("是 OrderStatusEvent = " + event);
        if (event instanceof OrderStatusEvent) {
            OrderStatusEvent<OrderStatus> orderStatusEvent = (OrderStatusEvent) event;
            OrderStatus source = orderStatusEvent.getSource();
            System.out.println("是 OrderStatusEvent  source=" + source);

        }
    }
}
