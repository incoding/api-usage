package com.javaapi.test.buisness.data.json.fastjson.pojo.bigdecimal;

import java.math.BigDecimal;

/**
 * Created by user on 2018/8/23
 */
public class Student {
    private Integer id;
    private BigDecimal balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
