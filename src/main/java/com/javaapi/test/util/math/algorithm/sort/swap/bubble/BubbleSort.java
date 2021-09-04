package com.javaapi.test.util.math.algorithm.sort.swap.bubble;

/**
 * Created by user on 2018/12/8
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1};
        System.out.println("排序前数组为：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        //外层循环控制排序趟数
        for(int i=0;i<arr.length-1;i++){
            //内层循环控制每一趟排序多少次
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println();
        System.out.println("排序后的数组为：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
