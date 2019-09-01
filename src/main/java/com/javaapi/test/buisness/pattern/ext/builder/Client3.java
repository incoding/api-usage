package com.javaapi.test.buisness.pattern.ext.builder;

import com.javaapi.test.buisness.pattern.ext.builder.builder.Builder2;
import com.javaapi.test.buisness.pattern.ext.builder.mode.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 示范根据泛型注入
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client3 {


    @Autowired
    Builder2<String, String, Person> person2Builder;

    @Autowired
    Builder2<String, Integer, Person> person2Builder2;


    @Test
    public void test() {
        Person firstname = person2Builder.build("firstname", "lastname2");
        System.out.println("firstname = " + firstname);
    }

    @Test
    public void test2() {
        Person firstname = person2Builder2.build("firstname2", 30);
        System.out.println("firstname = " + firstname);
    }


}
