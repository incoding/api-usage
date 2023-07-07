package com.javaapi.test.buisness.dao.mybatis.usage.extable.entity;

import lombok.Getter;
import lombok.Setter;

public class BillKvExt {

    @Getter
    @Setter
    private Long billId;
    private KvLine billUserId;
    private KvLine billUserName;

    public void setBillUserId(String billUserId) {
        if (billUserId == null) {
            return;
        }
        if (this.billUserId == null) {
            this.billUserId = new KvLine(billId, "billUserId", billUserId);
        }
        this.billUserId.setValue(billUserId);
    }

    public String getBillUserId() {
        if (this.billUserId == null) {
            return "";
        }
        return this.billUserId.getValue();
    }

    public void setBillUserName(String billUserName) {
        if (billUserName == null) {
            return;
        }
        if (this.billUserName == null) {
            this.billUserName = new KvLine(billId, "billUserName", billUserName);
        }
        this.billUserName.setValue(billUserName);
    }

    public String getBillUserName() {
        if (this.billUserName == null) {
            return "";
        }
        return this.billUserName.getValue();
    }
}
