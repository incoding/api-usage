package com.javaapi.test.test.dataStructure.link.reverse.traverse;

import com.javaapi.test.test.dataStructure.link.reverse.LinkedDataSupport;
import com.javaapi.test.test.dataStructure.link.reverse.Node;
import org.junit.Test;

/**
 * Created by user on 2018/11/2
 * 遍历翻转
 *
 *
 *
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
public class TraverseReverse {

    /**
     * 遍历翻转
     */
    @Test
    public void testReverse2() {
        Node head = LinkedDataSupport.getNode();
        // 打印反转前的链表
        LinkedDataSupport.print(head);
        // 调用反转方法
        head = reverse2(head);
        System.out.println("\n**************************");
        // 打印反转后的结果
        LinkedDataSupport.print(head);

    }

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node reverse2(Node head) {
        if (head == null) {
            return head;
        }
        Node pre = head;// 上一结点
        Node cur = head.getNext();// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }



}
