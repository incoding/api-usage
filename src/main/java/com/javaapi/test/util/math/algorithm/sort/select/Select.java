package com.javaapi.test.util.math.algorithm.sort.select;

import com.javaapi.test.pattern.structure.bridge.Jacket;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2018/12/8
 */
public class Select {
    @Test
    public void test(){
        int[] a = {5, 3, 2, 4, 1};
        System.out.println("before = " + Arrays.toString(a));
        for (int i=0;i<a.length;i++) {
            int temp = a[i];
            int flag = i;
            for (int j=i;j<a.length;j++) {
                if (a[j] < temp) {
                    flag = j;
                    temp = a[j];
                }
            }
            if (i != flag) {
                swap(a, i, flag);
            }
        }
        System.out.println("after = " + Arrays.toString(a));
    }

    private void swap(int[] a, int i, int flag) {
        int temp = a[i];
        a[i] = a[flag];
        a[flag] = temp;
    }

}
