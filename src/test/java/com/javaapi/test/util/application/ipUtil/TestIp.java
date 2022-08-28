package com.javaapi.test.util.application.ipUtil;

import org.junit.Test;

public class TestIp {
    public TestIp() {
    }

    @Test
    public void test() {
        long start2 = System.currentTimeMillis();

        IP.load("/Users/user/program/javatmp/17monipdb/17monipdb.dat");
        long end2 = System.currentTimeMillis();
        System.out.println("end = " + (end2 - start2));

        long start = System.currentTimeMillis();

        String[] strings = IP.find("219.237.242.60");
        long end = System.currentTimeMillis();
        System.out.println("end = " + (end - start));
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }
}