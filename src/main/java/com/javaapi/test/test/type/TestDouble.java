package com.javaapi.test.test.type;

import org.junit.Test;

/**
 * Created by user on 17/6/1.
 */
public class TestDouble {
    @Test
    public void test(){
        Double a = new Double(1980);
        changeDouble(a);
        System.out.println("a = " + a.toString());
    }

    private void changeDouble(Double a) {
        a = new Double(2080);
        System.out.println("a = " + a);
        Double.valueOf(1);
    }


    @Test
    public void test2(){
        Double a = new Double(1980);
        a = new Double(2020);
        System.out.println("a = " + a);
    }
}
