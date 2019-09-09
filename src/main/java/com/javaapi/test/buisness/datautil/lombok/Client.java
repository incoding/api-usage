package com.javaapi.test.buisness.datautil.lombok;

import org.junit.Test;

/**
 * Created by user on 2019/9/5
 */
public class Client {
    @Test
    public void test() {
        Person.PersonBuilder personBuilder = Person.builder().firstName("firstname").lastName("lastname");
        Person build = personBuilder.build();
        System.out.println("build = " + build);
    }

    @Test
    public void test2() {
        Person2 person2 = new Person2().setFirstName("first").setLastName("lastname");
        System.out.println("person2 = " + person2);
    }
}
