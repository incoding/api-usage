package com.javaapi.test.test.javafeature.version8.streams;

import org.junit.Before;
import org.junit.Test;
import org.testng.collections.Lists;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * java8 lambda 初探
 * http://blog.csdn.net/renfufei/article/details/24600507</br>
 * Lambda表达式的语法
 * 基本语法:
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }</br>
 * <p>总的来说,lambda表达式和 stream 是自Java语言添加泛型(Generics)和注解(annotation)以来最大的变化</p>
 * <p>
 * <p>
 * http://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
 */
public class ClientStream {

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
    public void testStreamOfNull(){
        List<String> list = null;
        // 会导致内部为空,但是不引发异常,所以要用filter过滤下
        Stream.of(list).forEach(System.out::println);
        List<Integer> collect = Stream.of(list).filter(strings -> strings!=null).map(strings -> strings.size()).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    public void testArray() throws Exception {

        int[] objects = {1, 2, 3};
        IntStream stream = Arrays.stream(objects);
        stream.forEach((s) -> System.out.println(s));
    }

    /**
     * IntStream、LongStream、DoubleStream。当然我们也可以用 Stream<Integer>、Stream<Long> >、Stream<Double>，但是 boxing 和 unboxing 会很耗时，所以特别为这三种基本数值型提供了对应的 Stream。
     */
    @Test
    public void testIntLongDouble_Stream() throws Exception {
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
        System.out.println("=========== ============");
        IntStream.range(1, 3).forEach(System.out::println);
    }

    /**
     * 一个 Stream 只可以使用一次，上面的代码为了简洁而重复使用了数次。

     * @throws Exception
     */
    @Test
    public void testTrans() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Stream<String> stream = list.stream();
        // 1. Array
        String[] strArray1 = stream.toArray(String[]::new);
        System.out.println("strArray1 = " + strArray1);
// 2. Collection
        List<String> list1 = stream.collect(Collectors.toList());
        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = stream.collect(Collectors.toSet());
        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
// 3. String
        String str = stream.collect(Collectors.joining()).toString();
    }

    @Test
    public void testStreamsForeachConsumer() {
        System.out.println("所有程序员的姓名:");
        javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    @Test
    public void testStreamsForeachConsumer2() {
        System.out.println("给程序员加薪 5% :");
        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        javaProgrammers.forEach(giveRaise);
        phpProgrammers.forEach(giveRaise);
    }

    /**
     * filter
     */
    @Test
    public void testStreamsFilter() {
        System.out.println("下面是月薪超过 $1,400 的PHP程序员:");
        List<Person> collect = phpProgrammers.stream()
                .filter((p) -> (p.getSalary() > 1400)).collect(toList());
        for (Person person : collect) {
            System.out.println("person = " + person);
        }
    }

    /**
     * filter
     */
    @Test
    public void testStreamsFilter2() {
        // 定义 filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

        System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // 重用filters
        System.out.println("年龄大于 24岁的女性 Java programmers:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    /**
     * 测试streams limit*
     */
    @Test
    public void testStreamsLimit() {
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
        System.out.println("最前面的3个 Java programmers:");
        List<Person> collect = javaProgrammers.stream()
                .limit(3).collect(toList());
        for (Person person : collect) {
            System.out.println("person = " + person);
        }
        //---------------
        System.out.println("最前面的3个女性 Java programmers:");
        javaProgrammers.stream()
                .filter(genderFilter)
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    /**
     * 测试streams sort和collect*
     */
    @Test
    public void testStreamsSort() {
        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        List<Person> sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        System.out.println("根据 salary 排序 Java programmers:");
        sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getSalary() - p2.getSalary()))
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));
    }

    /**
     * 测试 list sort
     */
    @Test
    public void testStreamsSort2() {
        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        javaProgrammers.sort((t1, t2) -> t1.getAge() - t2.getAge());
        System.out.println(javaProgrammers);
        javaProgrammers.sort((t1, t2) -> t2.getAge() - t1.getAge());
        System.out.println(javaProgrammers);
    }

    @Test
    public void testStreamsMinMax() {
        System.out.println("工资最低的 Java programmer:");
        Person pers = javaProgrammers
                .stream()
                .min((p1, p2) -> (p1.getSalary() - p2.getSalary())).get();

        System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());

        System.out.println("工资最高的 Java programmer:");
        Person person = javaProgrammers
                .stream()
                .max((p, p2) -> (p.getSalary() - p2.getSalary()))
                .get();

        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());
    }

    @Test
    public void testStreamsSort3() {
    /*    对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字：*/
        Collections.sort(javaProgrammers, (Person t1, Person t2) -> t1.getAge() - t2.getAge());
        System.out.println("javaProgrammers = " + javaProgrammers);
        /*但是你还可以写得更短点,Java编译器可以自动推导出参数类型*/
        Collections.sort(javaProgrammers, (t1, t2) -> t1.getAge() - t2.getAge());
    }

    /**
     * map
     *
     * @throws Exception
     */
    @Test
    public void testStreamsMap() throws Exception {
        for (Person javaProgrammer : javaProgrammers) {
            System.out.println("javaProgrammer = " + javaProgrammer);
        }
        List<Map<String, String>> collect = javaProgrammers.stream().map((p) -> {
            Map<String, String> map = new HashMap<String, String>();
            map.put(p.getFirstName(), p.getJob());
            return map;
        }).collect(toList());
        for (Map<String, String> stringStringMap : collect) {
            System.out.println("stringStringMap = " + stringStringMap);
        }

    }

    @Test
    public void testStreamCollect() {
        System.out.println("将 PHP programmers 的 first name 拼接成字符串:");
        String phpDevelopers = phpProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(joining(" ; ")); // 在进一步的操作中可以作为标记(token)

        System.out.println("将 Java programmers 的 first name 存放到 Set:");
        Set<String> javaDevFirstName = javaProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(toSet());

        Set<String> javaDevFirstName2 = javaProgrammers
                .stream()
                .map((e) -> e.getFirstName())
                .collect(toSet());
        System.out.println("javaDevFirstName2 = " + javaDevFirstName2);
        //=======
        System.out.println("将 Java programmers 的 first name 存放到 TreeSet:");
        TreeSet<String> javaDevLastName = javaProgrammers
                .stream()
                .map(Person::getLastName)
                .collect(toCollection(TreeSet::new));
    }

    @Test
    public void testStreamsParam() {
        System.out.println("计算付给 Java programmers 的所有money:");
        int totalSalary = javaProgrammers
                .parallelStream()
                .mapToInt(p -> p.getSalary())
                .sum();
        System.out.println(totalSalary);
        int totalSalaryNot = javaProgrammers
                .parallelStream()
                .mapToInt(p -> p.getSalary())
                .sum();
        System.out.println(totalSalaryNot);
    }

    @Test
    public void testStreamsStatistics() {
        //计算 count, min, max, sum, and average for numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());
    }


}
