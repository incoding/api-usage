package com.javaapi.test.buisness.result.abs;

import org.junit.Test;

/**
 * Created by user on 2019/3/3
 */
public class Client {
    @Test
    public void test() {
        BaseInfoResult<String, String> result = new BaseInfoResult<>();
        result.setBaseInfo(new BaseInfo<>("inputParam"));
    }
}
