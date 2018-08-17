package com.javaapi.test.testUtil.math.number;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * Created by user on 2018/8/9
 */
public class TestRandomUtils {
    @Test
    public void test(){
        int i = RandomUtils.nextInt(100000, 999999);
        System.out.println("i = " + i);
    }
}
