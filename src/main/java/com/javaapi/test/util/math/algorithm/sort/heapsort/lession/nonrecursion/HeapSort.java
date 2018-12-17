package com.javaapi.test.util.math.algorithm.sort.heapsort.lession.nonrecursion;


import java.util.Arrays;

/**
 * refer
 * https://blog.csdn.net/mine_song/article/details/69220998
 *
 */
public class HeapSort {
    public static void main(String[] args) {
//        int arr[] = { 4, 5, 2, 1, 8, 10, 2 };
        int arr[] = { 5, 4};
        System.out.println("before sort:" + Arrays.toString(arr));
        heapSortAsc(arr, arr.length);
        System.out.println("after sort:" + Arrays.toString(arr));
    }

    /**
     * 数组从0作为第一个结点，从下往上，从右往左， 第一个非叶结点为len / 2 - 1下标位置
     *
     * @param arr
     *            需要建立大顶堆的数组
     * @param len
     *            数组的长度
     */
    public static void buildMaxHeap(int arr[], int len) {
        // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个大顶堆。
        for (int i = len / 2 - 1; i >= 0; i--)
            // adjustDown(arr, i, len)
            adjustHeapWithRecur(arr, i, len);
    }

    /**
     * 大顶堆的向下调整算法 （非递归实现）
     *  注：数组实现的堆中， 第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     * 其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     *
     * @param arr
     *            待排序的数组
     * @param start
     *            被下调节点的起始位置(一般为0，表示从跟元素开始)
     * @param end
     *            截至范围(一般为数组中最后一个元素的索引)
     */
    public static void adjustDown(int[] arr, int start, int end) {
        int cur = start;// 当前(current)节点的位置
        int temp = arr[cur];
        int left = 2 * start + 1;// left左孩子，left + 1右孩子

        for (; left <= end; cur = left, left = 2 * left + 1) {
            // 选择左右孩子较大者
            if (left < end && arr[left] < arr[left + 1]) {
                left++;
            }
            // 当前结点和左右孩子大小相比较
            if (temp >= arr[left]) {
                break;
            }// 当前结点比左右孩子的较大者小
            else {
                // 交换
                arr[cur] = arr[left];
                arr[left] = temp;
            }
        }
    }

    /**
     * 大顶堆的向下调整算法 （递归实现）
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void adjustHeapWithRecur(int[] arr, int start, int end) {
        int temp = arr[start];
        int left = 2 * start + 1;
        if (left >= end) {
            return;
        }
        if (left < end - 1 && arr[left] < arr[left + 1]) {
            left++;
        }
        if (temp >= arr[left]) {
            return;
        }

        arr[start] = arr[left];
        arr[left] = temp;
        // 继续调整被破坏的子堆
        adjustHeapWithRecur(arr, left, end);
    }

    /**
     * 升序排序
     *
     * @param arr
     *            排序数组
     * @param len
     *            数组长度
     */
    public static void heapSortAsc(int arr[], int len) {
        buildMaxHeap(arr, len);
        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (int i = len - 1; i > 0; i--) {
            // 把最大值放在数组的末尾
            swap(arr, i, 0);
            // 继续调整0~i-1使之成为最大堆
//            adjustDown(arr, 0, i - 1);
            adjustHeapWithRecur(arr, 0, i - 1);
        }
    }

    /**
     * 不要囧,交换的一种实现而已
     * @param arr
     * @param i
     * @param j
     */
    // 交换
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}