package com.javaapi.test.util.opensource.apache.commons.lang;

import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;

/**
 * Created by user on 17/7/5.
 */
public class TestBooleanUtils {
    @Test
    public void test(){
        System.out.println("true = " + BooleanUtils.isTrue(null));
    }
}
