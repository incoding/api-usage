package com.javaapi.test.test.type.object.sample.spring.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by user on 2018/6/19
 */
@Data
public class ToBean {
    private String name;
    private String addressName;
    private BigDecimal bigDecimal;

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

}
