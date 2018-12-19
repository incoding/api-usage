package com.javaapi.test.test.javafeature.scope.model;

import org.junit.Test;


public class Client {
    @Test
    public void test() {
        InnerEntity in = new InnerEntity();
    }
    @Test
    public void test2() {
        InnerEntityPublick in = new InnerEntityPublick();
        System.out.println("in = " + in.name);
    }
}
