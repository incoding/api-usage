package com.javaapi.test.buisness.datatransfer.mapstruct.lesson10;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2019/8/17
 */
public class Client {

    @Test
    public void test() {
        HashMap<Long, Date> source = new HashMap<>();
        source.put(1L, new Date());
        Map<String, String> stringStringMap = SourceTargetMapper.INSTANCE.longDateMapToStringStringMap(source);
        System.out.println("stringStringMap = " + stringStringMap);
    }
}
