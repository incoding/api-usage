package com.javaapi.test.test.type.String.testString.behavior;

import org.junit.Test;

/**
 * Created by user on 2019/6/25
 */
public class TestStringConcat {
    @Test
    public void test(){
        String a = null;
        String b = "result="+a+" ";
        System.out.println("b = " + b);
    }
}
