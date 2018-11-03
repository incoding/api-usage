package com.javaapi.test.test.dataStructure.link.reverse;

import org.junit.Test;

/**
 * Created by user on 2018/11/2
 */
public class ClientSample2 {

    @Test
    public void testPoint(){



    }



    @Test
    public void test(){
        Node node = LinkedDataSupport.getNode();
        LinkedDataSupport.print(node);
        Node pre = node;
        Node cur = node.getNext();
        Node tmp = null;
        while (cur!=null) {
            // 避免当前node的原始next 丢失 start
            tmp = cur.getNext();
            // 避免当前node的原始next 丢失 end
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        // 原始头部要特别处理下
        node.setNext(null);
        System.out.println("=========");
        LinkedDataSupport.print(pre);

    }
}
