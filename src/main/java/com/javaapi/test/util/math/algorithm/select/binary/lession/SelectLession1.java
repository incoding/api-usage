package com.javaapi.test.util.math.algorithm.select.binary.lession;

import org.junit.Test;

/**
 * Created by user on 2019/1/6
 */
public class SelectLession1 {
    /**
     * 获取中间值
     */
    @Test
    public void test(){
        int mid = getMid(0,0);
        System.out.println("mid = " + mid);
        mid = getMid(2,3);
        System.out.println("mid = " + mid);
        mid = getMid(3,3);
        System.out.println("mid = " + mid);
    }


    /**
     * 注意 默认是向下取整   (2+3)/2  是得 2
     * @param low
     * @param high
     * @return
     */
    private int getMid(int low, int high) {
        int mid = (low + high) / 2;
        return mid;
    }
}
