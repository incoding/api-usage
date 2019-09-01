package com.javaapi.test.buisness.pattern.ext.builder.impl;


import com.javaapi.test.buisness.pattern.ext.builder.builder.Builder4;
import com.javaapi.test.buisness.pattern.ext.builder.context.Builder4Context;
import com.javaapi.test.buisness.pattern.ext.builder.mode.Person;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/9/1
 */
@Component
public class Person4Builder implements Builder4<Builder4Context, Person> {

    @Override
    public Person build(Builder4Context e) {
        Person person = new Person();
        person.setFirstName(e.getFirstName());
        person.setLastName(e.getLastName());
        person.setAge(e.getAge());
        return person;
    }
}
