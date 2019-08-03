package com.javaapi.test.buisness.data.json.fastjson.pojo.setcase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by user on 2019/7/3
 */
public class Client {
    @Test
    public void test() {
        String str = "[\n" +
                "  \"nihao\",\n" +
                "  \"nihao2\",\n" +
                "  \"nihao\"\n" +
                "]";
        HashSet<String> strings = JSON.parseObject(str, new TypeReference<HashSet<String>>() {
        });
        System.out.println("strings = " + strings);
    }

    @Test
    public void testEmptyString() {
        String str = "[\"\",\"nihao\"]";
        HashSet<String> strings = JSON.parseObject(str, new TypeReference<HashSet<String>>() {
        });
        System.out.println("strings = " + strings);
        System.out.println("strings = " + strings.contains(StringUtils.EMPTY));
    }
}
