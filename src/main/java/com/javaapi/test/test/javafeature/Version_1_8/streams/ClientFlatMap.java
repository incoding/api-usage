package com.javaapi.test.test.javafeature.Version_1_8.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 *http://ifeve.com/stream/
 */
public class ClientFlatMap {

    private List<Person> phpProgrammers;
    private List<Person> javaProgrammers;

    @Before
    public void setUp() {
        javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
    }



    @Test
    public void testMap() {
        List<List<String>> collect = Stream.of(asList("Tony", "Tom", "John"),
                asList("Amy", "Emma", "Iris"))
                .map(names -> names)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }


    /**
     * 平面化集合資料。將不同集合中的資料串接在一起，成為在一起的一組集合。
     http://blog.tonycube.com/2015/10/java-java8-3-stream.html


     https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
     flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。
     */

    @Test
    public void testFlatMap(){
        List<String> allNames = Stream.of(asList("Tony", "Tom", "John"),
                asList("Amy", "Emma", "Iris"))
                .flatMap(names -> names.stream())
                .collect(Collectors.toList());
        System.out.println(allNames.toString());
    }
    @Test
    public void testFlatMap2(){
        Stream<List<Integer>> integerListStream = Stream.of(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );

        Stream<Integer> integerStream = integerListStream .flatMap(Collection::stream);
        integerStream.forEach(System.out::println);
    }



















    @Test
    public void convertStringToUpperCaseStreams() {
        List<String> collected = Stream.of("a", "b", "hello") // Stream of String
                .map(string -> string.toUpperCase()) // Returns a stream consisting of the results of applying the given function to the elements of this stream.
                .collect(Collectors.toList());
//        assertEquals(asList("A", "B", "HELLO"), collected);
        System.out.println("collected = " + collected);
    }

    @Test
    public void testflatMap() throws Exception {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4)) // Stream of List<Integer>
                .flatMap(numbers -> numbers.stream())
                .map(integer -> integer + 1)
                .collect(Collectors.toList());
        System.out.println("together = " + together);
//        assertEquals(asList(2, 3, 4, 5), together);
    }


}
