package com.javaapi.test.buisness.skill.bit.modulo;

import org.junit.Test;

/**
 * Created by user on 2018/9/16
 * 看到这个会想起子网掩码
 */
public class Client {
    /**
     * 利用位运算    与操作 取模
     */
    @Test
    public void test(){
        String s = "1111";
        int i = Integer.parseInt(s, 2);
        System.out.println("i = " + i);

        int i1 = 17 & i;
        System.out.println("i1 = " + i1);
    }
}
