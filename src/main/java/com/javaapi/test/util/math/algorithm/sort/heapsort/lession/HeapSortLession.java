package com.javaapi.test.util.math.algorithm.sort.heapsort.lession;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 *  堆排序背景知识
 *  1 当前节点 ,左子树,右子树关系
 *  2 最后一个非叶子节点怎么算
 */
@Slf4j
public class HeapSortLession {
    private int arr[] = { 4, 5, 2, 1, 8, 10, 2 };
    /**
     * 当前节点的,左子树和右子树
     */
    @Test
    public void testScanAllIndex(){
        for (int i = 0; i < arr.length; i++) {
            int left = getLeft(i);
            int right = getRight(i);
            log.info("当前节点 ={} ,左子树={},右子树={}",i,left,right);
        }
    }

    /**
     * 1 如果一直遍历会报错
     * 2 所以要遍历到最后一个非叶子节点
     */
    @Test
    public void testScanAllNode(){
        for (int i = 0; i < arr.length; i++) {
            int left = getLeft(i);
            int right = getRight(i);
            print(i, left, right);
        }
    }

    @Test
    public void testScanNoneLeaf(){
        for (int i = 0; i < (arr.length/2)-1; i++) {
            int left = getLeft(i);
            int right = getRight(i);
            print(i, left, right);
        }
    }

    private void print(int i, int left, int right) {
        log.info("===================");
        log.info("当前节点 index={} value={}", i, arr[i]);
        log.info("当前左子树 index={} value={}", left, arr[left]);
        log.info("当前右子树 index={} value={}", right, arr[right]);
    }


    private int getRight(int i) {
        int left = getLeft(i);
        return left+1;
    }

    private int getLeft(int i) {
        int left =2 * i + 1;
        return left;
    }
}
