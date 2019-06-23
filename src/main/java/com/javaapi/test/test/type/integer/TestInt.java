package com.javaapi.test.test.type.integer;

import org.junit.Test;

import java.io.Serializable;

/**
 * Created by user on 16/3/24.
 */
public class TestInt {

    private  int a = 111_222;

    @Test
    public void testXiaHuaXian(){
        System.out.println("a = " + a);
    }


    @Test
    public void test(){
        int a = 0;
//        if (a == null) {
//
//        }

    }


    @Test
    public void testSeri() {
        int a = 11;
        ser(a);
    }
    public void ser(Serializable a ){
        System.out.println("a = " + a);
    }



    public static final byte CHECKED = 2;

    @Test
    public void testName() throws Exception {
        System.out.println(CHECKED);
        System.out.println(CHECKED == 2);
    }

    /**
     * 测试 只要是 null 跟原始类型比就会报错
     */
    @Test
    public void testNullFirst(){
        Integer a = null ;
        if (a !=0) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    /**
     * 测试 只要是 null 跟原始类型比就会报错
     */
    @Test
    public void testNullSecond(){
        Integer a = null ;
        if (0 != a) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
