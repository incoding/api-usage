package com.javaapi.test.test.type.booleancase;

import org.junit.Test;

/**
 * Created by user on 16/1/22.
 */
public class Client {
    @Test
    public void test() {
        Boolean a = new Boolean(true);
        System.out.println(a.equals(Boolean.TRUE));
        // 俩个对象做比较肯定不同
        System.out.println(a == Boolean.TRUE);
        System.out.println(null == Boolean.TRUE);
    }

    @Test
    public void test_v2() throws Exception {
        Boolean a = null;
        System.out.println(a == true);
    }
    @Test
    public void test_v3(){

        System.out.println("true = " + Boolean.TRUE.equals(null));
    }
}
