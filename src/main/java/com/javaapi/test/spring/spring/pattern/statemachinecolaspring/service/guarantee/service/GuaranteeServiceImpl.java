package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GuaranteeServiceImpl {

    public void cancelOrder(Long orderId) {
        log.info("订单取消");
        if (Long.valueOf(3).equals(orderId)) {
            log.info("订单取消发生异常");
            throw new RuntimeException("订单取消发生异常");
        }

    }
}
