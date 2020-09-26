package com.javaapi.test.application.jms.rocketmq.primitive.features.transaction.right.util;

/**
 * Created by user on 2020/9/22.
 */
public class Snowflake {
    public Snowflake(int i, int i1) {

    }

    public Long nextId() {
        // 这里应该是分布式id
        return 1L;
    }

    public String nextIdStr() {
        // 这里应该是分布式id 字符串
        return "1";
    }
}
