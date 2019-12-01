package com.javaapi.test.businessdesign.howtoextend.extendGenericPractice;

import org.junit.Test;

/**
 * Created by user on 2019/12/1
 */
public class Client {
    @Test
    public void test() {
        Son son = new Son();
        son.invoke();
    }
}
