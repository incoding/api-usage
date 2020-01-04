package com.javaapi.test.test.dataStructure.link.reverse;

import org.junit.Test;

/**
 * Created by user on 2018/11/2
 */
public class ClientSampleSelf {

    @Test
    public void testPoint() {
        Node head = LinkedDataSupport.getNode();
        Node current = head.getNext();
        Node before = head;
        Node next;
        while (current.getNext() != null) {
            next = current.getNext();
            current.setNext(before);
            before = current;
            current = next;
        }
        current.setNext(before);
        head.setNext(null);
        head = current;
        System.out.println("-------");
        LinkedDataSupport.print(head);

    }

}
