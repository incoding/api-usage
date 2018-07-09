package com.javaapi.test.testUtil.time.javajdk;

/**
 * Created by user on 17/12/25.
 */
public class TestParent {
    protected String transactionId = String.valueOf(System.currentTimeMillis());

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
