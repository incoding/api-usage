package com.javaapi.test.test.dataStructure.link.reverse;

import org.junit.Test;

/**
 * Created by user on 18/2/26.
 */
public class ClientSample {


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
        head = reverse4(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }


    /**
     * kk 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node reverse3(Node head) {
        if (head == null) {
            return head;
        }

        Node pre = head;// 上一结点
        Node cur = head.getNext();// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (true) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向
            if (tmp == null) {
                head.setNext(null);
                return cur;
            }
            // 指针往下移动
            pre = cur;
            cur = tmp;
        }

    }

    /**
     * kk 递归，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node reverse4(Node head) {
        if (head==null || head.getNext() == null) {
            return head;
        }
        Node reHead = reverse4(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }
}
