package com.javaapi.test.buisness.pattern.ext.listener;


import org.junit.Test;

/**
 * Created by user on 2018/12/28
 */
public class Client {

    /**
     * 匿名函数初始化
     */
    @Test
    public void testAnonymous(){
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

    @Test
    public void testConcrete(){
        OrderStatusManager orderStatusManager = new OrderStatusManager();
        orderStatusManager.addOrderStatusListener(new OrderStatusEventListener());
        orderStatusManager.notifyListeners(new OrderStatusEvent(OrderStatus.INIT));

    }



    @Test
    public void testType() throws Exception {
        OrderStatusSuccessListener<String> stringOrderStatusSuccessListener = new OrderStatusSuccessListener<>();
        stringOrderStatusSuccessListener.change("nihao");
        OrderStatusSuccessListener<OrderStatusEvent<OrderStatus>> eventListener = new OrderStatusSuccessListener<OrderStatusEvent<OrderStatus>>();
        OrderStatusEvent<OrderStatus> event = new OrderStatusEvent<>(OrderStatus.INIT);
        eventListener.change(event);

    }
}
