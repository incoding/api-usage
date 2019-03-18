package com.javaapi.test.util.math.algorithm.sort.bubble;

/**
 * 使@{@link BubbleSort} 逻辑清晰
 * 举个例子
 * 从小到大排序
 * 1 到底有几趟?如果对10个数排序,那么只要将9个位置的数确定就可以了,因为最后一个自然就是最值
 * 这9趟每趟的作用就是确定一个位置的数
 * 2 所以每一趟就从左到右的遍历,发现左面的数比右面的数大就交换数据
 *
 *
 */
public class BubbleSort3_2 {
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 2, 9, 1};
        System.out.println("排序前数组为：");
        print(arr);
        bubbleSort(arr);
        System.out.println("排序后的数组为：");
        print(arr);
    }

    private static void bubbleSort(int[] arr) {
        for(int i=0;i< (arr.length-1);i++) {
            for(int j=0;j<(arr.length-1)-i;j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                }
            }
        }

    }

    private static void print(int[] arr) {
        System.out.println();
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
