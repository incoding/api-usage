package com.javaapi.test.test.testJavaFeature.Version_1_8.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * http://blog.csdn.net/dm_vincent/article/details/40340291
 */
public class ClientStreamTrans {
    //
    private List<Person> phpProgrammers;
    private List<Person> javaProgrammers;

    public static Predicate<Person> checkIfStartsWith(final String letter) {
        return p -> p.getFirstName().startsWith(letter);
    }



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
                add(new Person("Evonne", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
    }

    /**
     * lambda的重用
     */
    @Test
    public void test() {
        final Predicate<Person> startsWithN = p -> p.getFirstName().startsWith("J");
        final Predicate<Person> startsWithB = p -> p.getFirstName().startsWith("C");

        final long countFriendsStartN = javaProgrammers.stream().filter(startsWithN).count();
        final long countFriendsStartB = javaProgrammers.stream().filter(startsWithB).count();
        System.out.println(countFriendsStartN);
        System.out.println(countFriendsStartB);
        //-----------------------
        final long countFriendsStartJ = javaProgrammers.stream().filter(checkIfStartsWith("J")).count();
        final long countFriendsStartC = javaProgrammers.stream().filter(checkIfStartsWith("C")).count();
        //-------------------------
        final Function<String, Predicate<Person>> startsWithLetter =
                (String letter) -> {
                    Predicate<Person> checkStartsWith = (Person name) -> name.getFirstName().startsWith(letter);
                    return checkStartsWith;
                };

        final Function<String, Predicate<Person>> startsWithLetterBest = (String letter) -> (Person name) -> name.getFirstName().startsWith(letter);
        final Function<String, Predicate<Person>> startsWithLette3 = letter -> name -> name.getFirstName().startsWith(letter);

        final long countFriendsStartJ_best = javaProgrammers.stream().filter(startsWithLetterBest.apply("J")).count();
        System.out.println("countFriendsStartJ_best = " + countFriendsStartJ_best);

    }



    @Test
    public void testCollectorsToMap() throws Exception {
        long start = System.currentTimeMillis();
        Map<String, Person> collect = phpProgrammers.stream().collect(Collectors.toMap((p) -> p.getFirstName(), (p) -> p, (oldVal, newVal) -> newVal));
        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
        collect.forEach((k, v) -> System.out.println(k + "======" + v));
    }

    @Test
    public void testCollectorJoining() throws Exception {
        String collect = javaProgrammers.stream().map(p -> p.getFirstName().toUpperCase()).collect(Collectors.joining(", "));
        System.out.println("collect = " + collect);
    }

    @Test
    public void testCollectorGroupBy() throws Exception {
        Map<Integer, List<Person>> collect = javaProgrammers.stream().collect(Collectors.groupingBy(Person::getAge));
        collect.forEach((k, v) -> System.out.println(k + "===" + v));
    }

    /**
     * http://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
     * 在使用条件“年龄小于 18”进行分组后可以看到，不到 18 岁的未成年人是一组，成年人是另外一组。partitioningBy 其实是一种特殊的 groupingBy，它依照条件测试的是否两种结果来构造返回的数据结构，get(true) 和 get(false) 能即为全部的元素对象。*/
    @Test
    public void testCollectorPartitioningBy() throws Exception {
        Map<Boolean, List<Person>> s1 = javaProgrammers.stream().collect(Collectors.partitioningBy((s) -> s.getFirstName().startsWith("S")));
        System.out.println("s1 = " + s1);
    }


    /**
     * mapping 配合分组操作
     * @throws Exception
     */
    @Test
    public void testGroupingName() throws Exception {
        Map<String, List<String>> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender(), Collectors.mapping((s) -> s.getFirstName(), Collectors.toList())));
        collect.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    /**
     * //按性别求年龄的总和
     * This is a generalization of reducing(Object, BinaryOperator) which allows a transformation of the elements before reduction.
     * @throws Exception
     */
    @Test
    public void testGroupingName2() throws Exception {
        Map<String, Integer> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender(), Collectors.reducing(0, Person::getAge, Integer::sum)));
        collect.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    /**
     *  //按性别求年龄的平均值
     * @throws Exception
     */
    @Test
    public void testGroupingName3() throws Exception {
        Map<String, Double> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender(), Collectors.averagingInt(Person::getAge)));
        collect.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    /**
     * http://developer.51cto.com/art/201404/435431.htm
     * @throws Exception
     */
    @Test
    public void testGroupingName4() throws Exception {
        Map<String, Integer> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender(), Collectors.summingInt(p -> 1)));

        collect.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    /**
     * 统计最大,最小,平局值,和,命中个数
     * @throws Exception
     */
    @Test
    public void testGroupingName5() throws Exception {
        Map<String, IntSummaryStatistics> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender(), Collectors.summarizingInt(p -> 1)));
        collect.forEach((k, v) -> System.out.println(k + " = " + v));
    }




    @Test
    public void testCollectorToList() throws Exception {
        long start = System.currentTimeMillis();

        List<Map<Object, Object>> collect1 = javaProgrammers.stream().map((p) -> {
            HashMap<Object, Object> map = new HashMap<>();
            map.put(p.getFirstName(), p.getLastName());
            return map;
        }).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);


        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
    }



    @Test
    public void testToArray() throws Exception {
        Integer[] a = {1, 1, 2, 3};
        Stream<Integer> stream = Stream.of(a);
        stream.forEach((s) -> {
            System.out.println(s);
        });

    }


    @Test
    public void testReduce() throws Exception {
        int sum = javaProgrammers.stream()
                .mapToInt(p -> p.getFirstName().length())
                .sum();
        System.out.println("Total number of characters in all names: " +
                sum);

    }

    /**
     * reduce
     * 在对一个集合中的元素按照顺序进行两两操作时，根据某种策略来得到一个结果，得到的结果将作为一个元素参与到下一次操作中，最终这个集合会被归约成为一个结果。这个结果也就是reduce方法的返回值。<br>
     * 第一次执行两两操作时，name1和name2代表的是集合中的第一个和第二个元素，当第一个元素的长度大于等于第二个元素时，将第一个元素保留下来，否则保留第二个元素。 第二次执行两两操作时，name1代表的是上一次操作中被保留下来的拥有较长长度的元素，name2代表的是第三个元素。 以此类推...最后得到的结果就是集合中第一个拥有最长长度的元素了。<br>
     * reduce方法返回的对象类型时Optional，这是因为待操作的集合可能是空的。<br>
     * reduce方法是会按照集合的顺序对其元素进行两两操作的，可以额外传入一个值作为“基础值”或者“默认值”，那么在第一次进行两两操作时，第一个操作对象就是这个额外传入的值，第二个操作对象是集合中的第一个元素<br>
     */
    @Test
    public void testReduce2() throws Exception {
        final Optional<Person> aLongName = javaProgrammers.stream()
                .reduce((person1, person2) ->
                        person1.getFirstName().length() >= person2.getFirstName().length() ? person1 : person2);
        aLongName.ifPresent(person -> System.out.println(String.format("A longest name: %s", person.getFirstName())));
    }



    /**
     * map reduce
     * http://blog.csdn.net/dm_vincent/article/details/40856569
     *
     * @throws Exception
     */
    @Test
    public void testMapReduce() throws Exception {

    }
}
