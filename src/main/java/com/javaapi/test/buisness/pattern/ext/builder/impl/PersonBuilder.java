package com.javaapi.test.buisness.pattern.ext.builder.impl;


import com.javaapi.test.buisness.pattern.ext.builder.builder.Builder;
import com.javaapi.test.buisness.pattern.ext.builder.mode.Person;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/9/1
 */
@Component
public class PersonBuilder implements Builder<String, Person> {

    @Override
    public Person build(String name) {
        Person person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        return person;
    }
}
