package com.javaapi.test.application.jms.rocketmq.primitive.features.transaction.right.domain;

/**
 * Created by user on 2020/9/22.
 */
public class TransactionLog {
    private String id;
    private String business;
    private String foreignKey;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBusiness() {
        return business;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public String getForeignKey() {
        return foreignKey;
    }
}
