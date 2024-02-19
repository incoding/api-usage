package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GuaranteeServiceImpl {


    public void createOrder(){
        log.info("创建订单成功");
    }

    public void check(boolean checkResult, Long orderId){
        log.info("审核结果:{}", checkResult);
        if (!checkResult) {
            // 拒绝
            cancelOrder(orderId);
        }
        //同意
    }


    public void cancelOrder(Long orderId) {
        log.info("订单取消");
        if (Long.valueOf(3).equals(orderId)) {
            log.info("订单取消发生异常");
            throw new RuntimeException("订单取消发生异常");
        }
    }

    public void paySuccess(){
        log.info("支付成功");
    }
}
