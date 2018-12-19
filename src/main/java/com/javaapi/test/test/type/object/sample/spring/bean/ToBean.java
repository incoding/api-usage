package com.javaapi.test.test.type.object.sample.spring.bean;

import java.math.BigDecimal;

/**
 * Created by user on 2018/6/19
 */
public class ToBean {
    private BigDecimal bigDecimal;

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ToBean{");
        sb.append("bigDecimal=").append(bigDecimal);
        sb.append('}');
        return sb.toString();
    }
}
