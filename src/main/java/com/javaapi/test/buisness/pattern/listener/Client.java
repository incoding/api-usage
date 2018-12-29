package com.javaapi.test.buisness.pattern.listener;


/**
 * Created by user on 2018/12/28
 */
public class Client {
    public static void main(String[] args) {

        OrderStatusManager orderStatusManager = new OrderStatusManager();
        orderStatusManager.addOrderStatusListener(new OrderStatusChangeListener<OrderStatusEvent<OrderStatus>>() {
            @Override
            public void change(OrderStatusEvent<OrderStatus> event) {
                OrderStatus source = event.getSource();
                if (!OrderStatus.INIT.equals(source)) {
                    return;
                }
                System.out.println("监听到成功实践" + source);
            }
        });
        orderStatusManager.addOrderStatusListener(new OrderStatusChangeListener<OrderStatusEvent<OrderStatus>>() {
            @Override
            public void change(OrderStatusEvent<OrderStatus> event) {
                OrderStatus source = event.getSource();
                if (!OrderStatus.FINISH.equals(source)) {
                    return;
                }
                System.out.println("监听到取消事件" + source);
            }
        });

        orderStatusManager.notifyListeners(new OrderStatusEvent(OrderStatus.FINISH));
        orderStatusManager.notifyListeners(new OrderStatusEvent(OrderStatus.INIT));
    }
}
