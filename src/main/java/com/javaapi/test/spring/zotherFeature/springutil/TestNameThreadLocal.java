package com.javaapi.test.spring.zotherFeature.springutil;

import org.junit.Test;
import org.springframework.core.NamedThreadLocal;

/**
 * Created by user on 15/8/24.
 */
public class TestNameThreadLocal {
    @Test
    public void test(){
        NamedThreadLocal<String> n = new NamedThreadLocal<>("name thread");
        n.set("nihao");
        n.set("hello");
        System.out.println("n = " + n);
    }
}
