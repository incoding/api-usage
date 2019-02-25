package com.javaapi.test.application.arithmetic.sort.bitSort;

import org.junit.Test;

/**
 * 位图对
 http://www.2cto.com/kf/201302/188243.html
 */
public class BitSort {
    @Test
    public void test(){

        int[] data = {4,10,19,1,9,6,4,9};
//[1-20] 因为这些数字都在1-20之间
        int[] a = new int[20];//默认全0
        for(int i=0;i < data.length;i++){
            if(a[ data[i] ] != 1){
                a[ data[i] ] = 1;
            }else{
                System.out.println(data[i]+" 是重复的数字");
            }
        }
        System.out.println("排序结果");
        for(int i=1;i<=19;i++){
            if( a[i] == 1){
                //输出下标
                System.out.print(i+" ");
            }
        }

        System.out.println("\n10是否在这个数组里面?");
        System.out.println(a[10]==1);
    }
}
