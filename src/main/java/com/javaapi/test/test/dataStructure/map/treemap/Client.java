package com.javaapi.test.test.dataStructure.map.treemap;

import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by user on 18/1/23.
 */
public class Client {

    /**
     * 返回逆向
     */
    @Test
    public void test() {
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("2018-01-23", new Object());
        map.put("2018-01-22", new Object());
        map.put("总数", new Object());
        System.out.println(map.toString());
        System.out.println(map.descendingMap().toString());

    }
}
