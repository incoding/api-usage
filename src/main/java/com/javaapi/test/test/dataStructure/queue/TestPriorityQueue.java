package com.javaapi.test.test.dataStructure.queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestPriorityQueue {

    @Test
    public void test() {
        Queue<String> q = new PriorityQueue<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // null,因为队列为空

    }

    /**
     * 这段代码 其实就是  读数组索引1 ,然后构建小堆顶
     */
    @Test
    public void test2() {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return n[1] - m[1];
            }
        });


        queue.offer(new int[]{1, 2});
        queue.offer(new int[]{1, 3});
        queue.offer(new int[]{1, 4});
        queue.offer(new int[]{2, 1});
        queue.offer(new int[]{2, 2});
        queue.offer(new int[]{2, 3});
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] poll = queue.poll();
            System.out.println(Arrays.toString(poll));

        }

    }

}
