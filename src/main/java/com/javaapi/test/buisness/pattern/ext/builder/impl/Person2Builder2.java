package com.javaapi.test.buisness.pattern.ext.builder.impl;


import com.javaapi.test.buisness.pattern.ext.builder.builder.Builder2;
import com.javaapi.test.buisness.pattern.ext.builder.mode.Person;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/9/1
 */
@Component
public class Person2Builder2 implements Builder2<String, Integer, Person> {

    @Override
    public Person build(String s, Integer s2) {
        Person person = new Person();
        person.setFirstName(s);
        person.setAge(s2);
        return person;
    }

}
