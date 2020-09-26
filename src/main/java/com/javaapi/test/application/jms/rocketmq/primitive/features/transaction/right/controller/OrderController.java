package com.javaapi.test.application.jms.rocketmq.primitive.features.transaction.right.controller;

import com.javaapi.test.application.jms.rocketmq.primitive.features.transaction.right.dto.OrderDTO;
import com.javaapi.test.application.jms.rocketmq.primitive.features.transaction.right.service.OrderService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2020/9/22.
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/create_order")
    public void createOrder(@RequestBody OrderDTO order) throws MQClientException {
        logger.info("接收到订单数据：{}", order.getCommodityCode());
        orderService.createOrder(order);
    }
}