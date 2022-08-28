package com.javaapi.test.util.collections.arrays;

import org.junit.Test;

import java.util.Arrays;

public class TestArrays {
    @Test
    public void test() {
        int[] a = new int[15];
        Arrays.fill(a, 333);
        System.out.println("a = " + Arrays.toString(a));
    }
}
