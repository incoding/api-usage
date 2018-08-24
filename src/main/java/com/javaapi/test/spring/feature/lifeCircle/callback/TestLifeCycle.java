package com.javaapi.test.spring.feature.lifeCircle.callback;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class TestLifeCycle {
    @Autowired
    private BeanFactory bf;


    @Test
    public void testLifeCycle() throws Exception {
        HelloWorld hello = (HelloWorld) bf.getBean("helloWorld");
//        Assert.assertEquals("hello world!", hello.getHello());
//        hello.destroy();
    }
}