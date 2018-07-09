package com.javaapi.test.buisness.testBit.base;

import org.junit.Test;

/**
 * http://blog.csdn.net/thesnowboy_2/article/details/51862397
 * http://blog.csdn.net/oqqYeYi/article/details/39831029   (好)
 * 十进制转二进制
 */
public class TestBit3 {
    @Test
    public void test() {
        Integer data = 8;
        String binaryStr = getBinary(data);
        System.out.println("binaryStr = " + binaryStr);
    }

    private String getBinary(Integer data) {
        return Integer.toBinaryString(data);
    }

    @Test
    public void testMi() {
        getMi(2);
        System.out.println("===============");
    }
    @Test
    public void testMi2() {
        int length = 16;
        for (int h = 0; h < 17; h++) {
            int i1 = h & (length - 1);
            System.out.println(getBinary(h) +"=h="+h);
            System.out.println(getBinary(length-1)+"= length-1="+(length-1));
            System.out.println(getBinary(i1)+" = i1="+i1);
            System.out.println("--------");

        }

    }

    private void getMi(int a) {
        for (int j = 6; j < 11; j++) {
            Double pow = Math.pow(a, j);
            int data = pow.intValue();

            System.out.println(data +"=="+getBinary(data));
            for (int i = 100; i <107; i++) {
                System.out.println("h="+i+",length="+data+",binary="+getBinary(i)+",lengthBinary="+getBinary(data)+",h&length = " + (i&data)+",h&(length-1)= " + (i&(data-1)));
            }
        }
    }
}
