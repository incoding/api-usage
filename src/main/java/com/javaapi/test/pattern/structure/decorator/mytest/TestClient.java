package com.javaapi.test.pattern.structure.decorator.mytest;

import org.junit.Test;

public class TestClient {
    @Test
    public void testOtherDerocator() throws Exception {
        ManOper3 manOper3 = new ManOper3();
        ManOper2 manOper2 = new ManOper2();
        ManOper1 manOper1 = new ManOper1();
        Man man = new Man();
        manOper1.setPerson(man);
        manOper2.setPerson(manOper1);
        manOper3.setPerson(manOper2);
        manOper3.eat();
    }

}
