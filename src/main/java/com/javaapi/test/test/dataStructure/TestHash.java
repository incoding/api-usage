package com.javaapi.test.test.dataStructure;

import org.junit.Test;

/**
 * Created by user on 17/2/26.
 */
public class TestHash {
    /**
     * 试用下hashmap 获取index的方式
     * length要为2的n次方时候,碰撞几率最小
     */
    @Test
    public void test(){
        int length = 16;
        for (int j = 0; j < 10000; j++) {
            int i = indexFor(j, length);
            System.out.println("i = " + i);
        }

    }

    /**
     * 如果 length长度不为2的幂则,则计算出的索引碰撞几率非常高
     * http://blog.csdn.net/oqqYeYi/article/details/39831029 (好)
     *
     */
    @Test
    public void test2(){
        int length = 18;
        for (int j = 0; j < 10000; j++) {
            int i = indexFor(j, length);
            System.out.println("i = " + i);
        }

    }


    static int indexFor(int h, int length) {
        return h & (length-1);
    }
}
