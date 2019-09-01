package com.javaapi.test.test.component.cast;

import org.junit.Test;

/**
 * https://www.cnblogs.com/shengkejava/p/5988814.html
 */
public class Client {

    /**
     * 类型转换
     */
    @Test
    public void test() {
        String a = "nihao";

        String cast = String.class.cast(a);
        System.out.println("cast = " + cast);
        Integer cast1 = Integer.class.cast(a);
        System.out.println("cast1 = " + cast1);

    }
}
