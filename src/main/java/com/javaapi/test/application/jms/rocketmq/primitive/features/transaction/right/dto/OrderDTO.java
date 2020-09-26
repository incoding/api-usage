package com.javaapi.test.application.jms.rocketmq.primitive.features.transaction.right.dto;

/**
 * Created by user on 2020/9/22.
 */
public class OrderDTO {
    private Long id;
    private String orderNo;
    private String commodityCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }
}
