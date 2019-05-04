package com.javaapi.test.test.javafeature.version8.streams.streamcomparator;

import com.javaapi.test.test.javafeature.version8.streams.Person;
import org.junit.Before;
import org.junit.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * jdk 8 Comparator 的使用
 * refer http://www.importnew.com/15259.html
 * https://stackoverflow.com/questions/30374083/whats-the-meaning-of-the-character-in-the-returned-value
 */
public class ClientComparator {
    private List<Person> phpProgrammers;
    private List<Person> javaProgrammers;

    @Before
    public void setUp() {
        javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", null, 43, 2000));
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


    public static int compareByNameThenAge(Person lhs, Person rhs) {
        if (lhs.getLastName().equals(rhs.getLastName())) {
            return lhs.getAge() - rhs.getAge();
        } else {
            return lhs.getLastName().compareTo(rhs.getLastName());
        }
    }

    /**
     * 注意 stream sorted后是不影响原数据的
     */
    @Test
    public void testInfluence(){
        List<Integer> list = Lists.newArrayList(6, 2, 4, 1, 5, 8, 9, 3, 7 );
        List<Integer> collect = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("list = " + list);
    }


    @Test
    public void testCompareInt(){
        List<Integer> list = Lists.newArrayList(6, 2, 4, 1, 5, 8, 9, 3, 7 );
        List<Integer> collect = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }


    /**
     * use method reference
     */
    @Test
    public void test(){
        List<Person> collect = javaProgrammers.stream().sorted(ClientComparator::compareByNameThenAge).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * use comparator
     */
    @Test
    public void testComparator(){
        List<Person> collect = javaProgrammers.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * reverse
     */
    @Test
    public void testComparatorReverse(){
        List<Person> collect = javaProgrammers.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    /**
     *  gender asc
     *  age asc
     */
    @Test
    public void testComparatorThen(){
        List<Person> collect = javaProgrammers.stream().sorted(Comparator.comparing(Person::getGender).thenComparing(Person::getAge)).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    /**
     *  gender asc
     *  age desc
     */
    @Test
    public void testComparatorThenReverse(){
        Comparator<Person> comparatorAgeReverse = Comparator.comparing(Person::getAge).reversed();
        Comparator<Person> comparator = Comparator.comparing(Person::getGender).thenComparing(comparatorAgeReverse);
        List<Person> collect = javaProgrammers.stream().sorted(comparator).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    /**
     * //TODO
     */
    @Test
    public void testNullComparator(){

    }

}
