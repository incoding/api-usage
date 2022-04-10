package com.javaapi.test.test.dataStructure.stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


/**
 * https://blog.51cto.com/u_15047490/3650697
 * <p>
 * Java中栈和队列的实现类
 * Deque接口（双端队列）继承了队列Queue接口
 * Deque有两个主要的实现类：ArrayDeque（底层使用数组），LinkedList（底层使用双向链表）
 * Queue也有两个主要的实现类：ArrayDeque（底层使用数组），LinkedList（底层使用双向链表）
 */
public class StackTest {
    /**
     * jdk  栈实现
     */
    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


    @Test
    public void testDequeue() {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    @Test
    public void testLinkedList() {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
