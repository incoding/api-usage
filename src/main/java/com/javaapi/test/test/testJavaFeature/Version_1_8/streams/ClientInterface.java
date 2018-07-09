package com.javaapi.test.test.testJavaFeature.Version_1_8.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.toList;

/**
 * test jdk 8 new function    interface
 */
public class ClientInterface {

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

    /**
     * test lambda表达式
     */
    @Test
    public void test() {
        Collections.sort(javaProgrammers, (Person t1, Person t2) -> {
            return t1.getAge() - t2.getAge();
        });

           /*    对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字：*/
        Collections.sort(javaProgrammers, (Person t1, Person t2) -> t1.getAge() - t2.getAge());
        System.out.println("javaProgrammers = " + javaProgrammers);
        /*但是你还可以写得更短点,Java编译器可以自动推导出参数类型*/
        Collections.sort(javaProgrammers, (t1, t2) -> t1.getAge() - t2.getAge());
    }

    @Test
    public void testFunction1() throws Exception {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

    }

    @Test
    public void testPredicate() throws Exception {
        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println("predicate = " + predicate.test("foo"));     // true
        System.out.println("predicate = " + predicate.negate().test("foo"));  // false
        Predicate<Boolean> nonNull = Objects::nonNull;
        System.out.println("predicate = " + nonNull.test(true));
        Predicate<Boolean> isNull = Objects::isNull;
        System.out.println("predicate = " + isNull.test(true));

        Predicate<String> isEmpty = String::isEmpty;
        System.out.println("predicate = " + isEmpty.test(""));
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println("predicate = " + isNotEmpty.test(""));
    }

    @Test
    public void testPredicate2() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("nihao2");
        list.add("nihao23");
        list.add("nihao24");
        list.add("nihao255");
        Predicate<String> stringPredicate = (x) -> x.length() > 6 ? true : false;
        List<String> collect = list.stream().filter(stringPredicate).collect(toList());
        System.out.println("collect = " + list.stream().filter(stringPredicate).count());
        System.out.println("collect = " + collect);
    }

    @Test
    public void testFunction() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, Integer> toInteger2 = (s) -> Integer.valueOf(s);
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");     // "123"
        System.out.println("backToString = " + backToString.apply("123"));
        System.out.println("backToString = " + toInteger2.apply("123"));
    }

    @Test
    public void testSupplier() throws Exception {
        Supplier<String> personSupplier = String::new;
        System.out.println("personSupplier.get() = " + personSupplier.get());   // new Person
        System.out.println("==========");
        Supplier<String> personSupplier2 = () -> {
            System.out.println("nihaoaaaa");
            return "nihao";
        };
        System.out.println("personSupplier.get() = " + personSupplier2.get());   // new Person

    }
    /** 验证 **/
    @Test
    public void testDoubleSupplier(){
        DoubleSupplier doubleSupplier = () -> 5;
        double asDouble = doubleSupplier.getAsDouble();
        System.out.println(asDouble);
    }

    @Test
    public void testConsumer() throws Exception {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker", "java", "man", 23, 1024));

    }

    @Test
    public void testConsumer2() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach((x) -> System.out.println(x));
    }

    @Test
    public void testOptional() throws Exception {
        Optional<String> optional = Optional.of("bam");

        System.out.println("optional = " + optional.isPresent());// true
        System.out.println("optional = " + optional.get());   // "bam"
        System.out.println("optional = " + optional.orElse("fallback"));   // "bam"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

    }

    interface Converter<F, T> {
        T convert(F from);
    }
    /**
     * optinal
     */
    @Test
    public void testOptinal() throws Exception {
        List<String> collect = javaProgrammers.stream().map((person -> {
            return person.getFirstName();
        })).collect(toList());
        String sindyNew = pickName(collect, "Sindy");
        System.out.println("sindy = " + sindyNew);
        //---
        String sindy = pickName(collect, "11");
        System.out.println("sindy = " + sindy);

    }
    public static String pickName(final List<String> names, final String startingLetter) {
        final Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();
//        System.out.println(String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
        return foundName.isPresent() ? foundName.get() : foundName.orElse("not found");
    }


}
