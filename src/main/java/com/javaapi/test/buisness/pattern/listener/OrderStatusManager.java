package com.javaapi.test.buisness.pattern.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018/12/28
 */
public class OrderStatusManager {
    private List<OrderStatusChangeListener> list = new ArrayList<>();

    public void addOrderStatusListener(OrderStatusChangeListener orderStatusChangeListener) {
        if (list != null && !list.contains(orderStatusChangeListener)) {
            list.add(orderStatusChangeListener);
        }
    }

    public void removeOrderStatusListener(OrderStatusChangeListener orderStatusChangeListener) {
        if (list != null && list.contains(orderStatusChangeListener)) {
            list.remove(orderStatusChangeListener);
        }
    }

    public void notifyListeners(OrderStatusEvent event) {
        for (OrderStatusChangeListener orderStatusChangeListener : list) {
            orderStatusChangeListener.change(event);
        }
    }
}
