package com.javaapi.test.test.javafeature.version8.streams.streamcomparator;

import com.javaapi.test.test.javafeature.version8.streams.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * comparator & min & max
 */
public class ClientComparator2 {

    @Test
    public void testMinMax() {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", null, 43, 2000));
            }
        };
        Person person = javaProgrammers.stream().min(Comparator.comparing(Person::getAge)).orElse(null);
        System.out.println("person = " + person);
        person = javaProgrammers.stream().max(Comparator.comparing(Person::getAge)).orElse(null);
        System.out.println("person = " + person);

    }

    @Test
    public void testNoneMinMax() {
        List<Person> javaProgrammers = new ArrayList<>();
        Person person = javaProgrammers.stream().min(Comparator.comparing(Person::getAge)).orElse(null);
        System.out.println("min age person = " + person);
        person = javaProgrammers.stream().max(Comparator.comparing(Person::getAge)).orElse(null);
        System.out.println("max age person = " + person);
    }
}
