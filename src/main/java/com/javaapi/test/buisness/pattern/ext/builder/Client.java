package com.javaapi.test.buisness.pattern.ext.builder;

import com.javaapi.test.buisness.pattern.ext.builder.impl.Person2Builder;
import com.javaapi.test.buisness.pattern.ext.builder.impl.Person3Builder;
import com.javaapi.test.buisness.pattern.ext.builder.impl.PersonBuilder;
import com.javaapi.test.buisness.pattern.ext.builder.mode.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 示范不同构造器
 * 使用spring bean形式的builder可以获得更多能力
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Resource
    PersonBuilder personBuilder;

    @Resource
    Person2Builder person2Builder;

    @Resource
    Person3Builder person3Builder;


    @Test
    public void test() {
        Person firstname = personBuilder.build("firstname");
        System.out.println("firstname = " + firstname);
    }

    @Test
    public void test2() {
        Person firstname = person2Builder.build("firstname2", "lastname2");
        System.out.println("firstname = " + firstname);
    }

    @Test
    public void test3() {
        Person firstname = person3Builder.build("firstname2", "lastname2", 30);
        System.out.println("firstname = " + firstname);
    }
}
