package com.javaapi.test.buisness.pattern.ext.builder.impl;


import com.javaapi.test.buisness.pattern.ext.builder.builder.Builder3;
import com.javaapi.test.buisness.pattern.ext.builder.mode.Person;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/9/1
 */
@Component
public class Person3Builder implements Builder3<String, String, Integer, Person> {

    @Override
    public Person build(String s, String s2, Integer integer) {
        Person person = new Person();
        person.setFirstName(s);
        person.setLastName(s2);
        person.setAge(integer);
        return person;
    }
}
