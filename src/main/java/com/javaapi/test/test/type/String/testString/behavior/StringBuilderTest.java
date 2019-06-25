package com.javaapi.test.test.type.String.testString.behavior;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by user on 2019/5/15
 */
@Slf4j
public class StringBuilderTest {
    @Test
    public void test() {
        Long version = null;
        String id = null;
        StringBuilder stringBuilder = new StringBuilder();
        String s = stringBuilder.append(version).append(id).toString();
        System.out.println("s = " + s);
        log.info("输出为 {} ,{}", id, version);
        StringBuilder stringBuilder1 = new StringBuilder();
        System.out.println("s = " + stringBuilder1.toString().length());
    }
}
