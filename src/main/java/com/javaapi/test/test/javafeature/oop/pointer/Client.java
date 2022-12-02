package com.javaapi.test.test.javafeature.oop.pointer;

import com.javaapi.test.test.javafeature.oop.miscell.Person;
import org.junit.Test;

public class Client {

    /**
     * 教学 引用是基于复制的 case1
     **/
    @Test
    public void test() {
        Person a = new Person();
        a.setName("name a");

        Person c = new Person();
        c.setName("name c");

        Person b = a;
        a.setName("a_after");
        System.out.println("b.getName() = " + b.getName());
        a = c;
        System.out.println("a.getName() = " + a.getName());
        System.out.println("b.getName() = " + b.getName());
    }

    /**
     * 教学  引用是基于复制的 case2
     **/
    @Test
    public void test2() {
        Person a = new Person();
        a.setName("name a");
        changeB(a);
        System.out.println("a out of  method is " + a.getName());
    }

    private void changeB(Person a) {
        Person c = new Person();
        c.setName("name c");
        a = c;
        System.out.println("a in method is " + a.getName());
    }
}
