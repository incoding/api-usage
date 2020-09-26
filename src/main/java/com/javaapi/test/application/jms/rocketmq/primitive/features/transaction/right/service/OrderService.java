package com.javaapi.test.application.jms.rocketmq.primitive.features.transaction.right.service;

import com.javaapi.test.application.jms.rocketmq.primitive.features.transaction.right.dto.OrderDTO;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2020/9/22.
 */
public interface OrderService {
    //执行本地事务时调用，将订单数据和事务日志写入本地数据库
    @Transactional
    void createOrder(OrderDTO orderDTO, String transactionId);

    //前端调用，只用于向RocketMQ发送事务消息
    void createOrder(OrderDTO order) throws MQClientException;
}
