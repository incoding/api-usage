package com.javaapi.test.util.math.datastruct.link;

import org.junit.Test;

/**
 * 反转部分链表
 * 1->2->3->4->5
 * 开始 2 结束 4
 * <p>
 * 反转之后：
 * 1->4->3->2->5
 * <p>
 * <p>
 * <p>
 * 1->2->3
 * 1->2
 * <p>
 * <p>
 * <p>
 * 1->dummyStart->2->3->4->dummyEnd -> 5
 * <p>
 * 1->      4 -> 3 -> 2 ->       5
 * <p>
 * startPre -> 5
 */
public class TestLinked {


    @Test
    public void test() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        TestLinked testLinked = new TestLinked();
        ListNode reverse = testLinked.reverse(node1, 5, 5);
        testLinked.print(reverse);
    }

    public ListNode reverse(ListNode head, int left, int right) {
        int index = 1;
        ListNode dummy = new ListNode(0, head);
        ListNode startCur = dummy.next;

        ListNode startPre = dummy;
        while (index != left) {
            startPre = startCur;
            startCur = startCur.next;
            index++;
        }

        ListNode pre = null;
        ListNode cur = startCur;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            // 到达end
            if (index == right) {
                break;
            }
            index++;
        }
        startPre.next = pre;
        startCur.next = cur;
        return dummy.next;
    }

    public void print(ListNode node) {
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println("");
    }


    public class ListNode {
        int value;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
