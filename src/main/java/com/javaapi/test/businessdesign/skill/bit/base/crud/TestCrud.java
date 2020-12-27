package com.javaapi.test.businessdesign.skill.bit.base.crud;

import org.junit.Test;

/**
 * Created by user on 2020/12/27.
 */
public class TestCrud {

    /**
     * 或操作 添加特性
     */
    @Test
    public void testAdd() {
        int i = Integer.parseInt("1101", 2);
        int y = Integer.parseInt("0010", 2);
        System.out.println("Integer.toBinaryString(i | y) = " + Integer.toBinaryString(i | y));
    }

    /**
     * 与也可以以实现 移除特性
     * 1 某特性取反后与 原数据相与
     */
    @Test
    public void testRemove() {
        String s = "1101";
        int i = Integer.parseInt(s, 2);
        int y = ~Integer.parseInt("0100", 2);
        System.out.println("Integer.toBinaryString(i) = " + Integer.toBinaryString(i));
        System.out.println("Integer.toBinaryString(y) = " + Integer.toBinaryString(y));
        System.out.println("Integer.toBinaryString(i & y) = " + Integer.toBinaryString(i & y));
    }

    /**
     * 与操作查询
     */
    @Test
    public void testSelect() {
        String s = "1101";
        int i = Integer.parseInt(s, 2);
        int y = Integer.parseInt("0100", 2);
        System.out.println("Integer.toBinaryString(i & y) = " + ((i & y) == y));
    }
}
