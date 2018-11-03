package com.javaapi.test.test.dataStructure.link.reverse;

/**
 * Created by user on 2018/11/2
 */
public class LinkedDataSupport {
    public static  Node getNode() {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        return head;
    }

    public static void print (Node h){
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
    }
}
