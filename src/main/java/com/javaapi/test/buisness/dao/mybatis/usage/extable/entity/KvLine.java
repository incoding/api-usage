package com.javaapi.test.buisness.dao.mybatis.usage.extable.entity;

import lombok.Data;

@Data
public class KvLine implements IKvLine {
    private Long id;
    private Long billId;
    private String key;
    private String value;

    public KvLine() {
    }

    public KvLine(Long billId, String key, String value) {
        this.billId = billId;
        this.key = key;
        this.value = value;
    }
}
