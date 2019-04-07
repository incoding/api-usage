package com.javaapi.test.test.javafeature.Version_1_8.advance;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * test jdk8 map
 */
public class ClientOther {
    @Test
    public void test() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + (i + 1));
        }
        map.forEach((a, b) -> {
            System.out.println("a = " + a);
            System.out.println("b= " + b);
            System.out.println("======");
        });

        System.out.println("===================");

        // 重新设定map值
        System.out.println(map.computeIfPresent(3, (num, val) -> val + num));
        System.out.println(map.get(3));// val33
        System.out.println(map.computeIfPresent(9, (num, val) -> null));
        System.out.println(map.containsKey(9));     // false
        System.out.println(map.computeIfAbsent(23, num -> "val" + num));
        System.out.println(map.containsKey(23));    // true
        System.out.println(map.get(23));    // true
        System.out.println(map.computeIfAbsent(3, num -> "bam"));
        System.out.println(map.get(3));             // val33

        System.out.println("===========");


        String orDefault = map.getOrDefault(3, "5");
        System.out.println("orDefault = " + orDefault);
        String orDefault1 = map.getOrDefault(11, "5");
        System.out.println("orDefault1 = " + orDefault1);

        System.out.println("=========");
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9
        System.out.println(map.get(9));
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat
        System.out.println(map.get(9));
    }
}
