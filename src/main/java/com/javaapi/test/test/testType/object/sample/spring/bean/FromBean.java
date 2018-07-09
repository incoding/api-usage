package com.javaapi.test.test.testType.object.sample.spring.bean;

/**
 * Created by user on 2018/6/19
 */
public class FromBean {
    private double amount ;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FromBean{");
        sb.append("amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
