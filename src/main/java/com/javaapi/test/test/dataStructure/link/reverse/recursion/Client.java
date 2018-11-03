package com.javaapi.test.test.dataStructure.link.reverse.recursion;

import com.javaapi.test.test.dataStructure.link.reverse.LinkedDataSupport;
import com.javaapi.test.test.dataStructure.link.reverse.Node;
import org.junit.Test;

/**
 * 参考 http://blog.csdn.net/guyuealian/article/details/51119499
 * 俩种翻转 单向链表的方式
 * 1 递归翻转
 * 2 遍历翻转
 *
 * 递归翻转原理参考
 * http://blog.csdn.net/fx677588/article/details/72357389
 * https://www.cnblogs.com/kubixuesheng/p/4394509.html
 *
 * 递归不仅仅可以从最后开始,也可以从头开始
 * http://blog.csdn.net/willib/article/details/38386547
 * 用两种递归思路与循环实现单链表的反转
 */
 public class Client {
    /**
     * 1 递归翻转
     */
    @Test
    public void testReverse1() {
        Node head = LinkedDataSupport.getNode();


        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        head = Reverse1(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    public static Node Reverse1(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = Reverse1(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }




}

