package com.javaapi.test.test.javafeature.oop.pointer;

import com.javaapi.test.test.javafeature.oop.miscell.Person;
import org.junit.Test;

public class Client {
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
}
