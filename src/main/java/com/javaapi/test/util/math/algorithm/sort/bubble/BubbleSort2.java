package com.javaapi.test.util.math.algorithm.sort.bubble;

/**
 * 使@{@link BubbleSort} 逻辑清晰
 */
public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1};
        System.out.println("排序前数组为：");
        print(arr);
        bubbleSort(arr);
        System.out.println("排序后的数组为：");
        print(arr);
    }

    private static void bubbleSort(int[] arr) {
        //外层循环控制排序趟数
        for(int i=0;i<arr.length-1;i++){
            //内层循环控制每一趟排序多少次
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void print(int[] arr) {
        System.out.println();
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }

}
