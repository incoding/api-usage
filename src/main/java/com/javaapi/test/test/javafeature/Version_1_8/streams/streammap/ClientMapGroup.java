package com.javaapi.test.test.javafeature.Version_1_8.streams.streammap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Suppliers;
import com.javaapi.test.test.javafeature.Version_1_8.streams.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 *http://ifeve.com/stream/
 */
public class ClientMapGroup {

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
                add(new Person("Jayden", "Pam", "Java programmer", "female", 35, 1700));
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
     * 按照性别分组
     * @throws Exception
     */
    @Test
    public void testGrouppingBy1() throws Exception {
        Map<String, List<Person>> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender()));
        System.out.println(collect);
    }

    /**
     * 按照性别分组,并收集first name
     * @throws Exception
     */
    @Test
    public void testGrouppingBy2() throws Exception {
        Collector<Person, ?, List<String>> mapping = Collectors.mapping((s) -> s.getFirstName(), Collectors.toList());
        Map<String, List<String>> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender(), mapping));
        System.out.println("collect = " + collect.getClass());
        System.out.println("collect = " + JSON.toJSONString(collect, SerializerFeature.PrettyFormat));
    }

    /**
     * 按照性别分组,并收集first name ,  创建treemap
     * @throws Exception
     */
    @Test
    public void testGrouppingBy3() throws Exception {
        Collector<Person, ?, List<String>> mapping = Collectors.mapping((s) -> s.getFirstName(), Collectors.toList());
        Map<String, List<String>> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender(), TreeMap::new, mapping));
        System.out.println("collect = " + collect.getClass());
        System.out.println("collect = " + JSON.toJSONString(collect, SerializerFeature.PrettyFormat));
    }


    @Test
    public void testMapping1() throws Exception {
        Collector<Person, ?, List<String>> mapping = Collectors.mapping((s) -> s.getFirstName(), Collectors.toList());
        Map<String, List<String>> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender(), mapping));
        System.out.println("collect = " + JSON.toJSONString(collect, SerializerFeature.PrettyFormat));
    }

    @Test
    public void testReducing() throws Exception {
        Map<String, Integer> collect = javaProgrammers.stream().collect(Collectors.groupingBy((s) -> s.getGender(), Collectors.reducing(0, Person::getAge, Integer::sum)));
        collect.forEach((k, v) -> System.out.println(k + " = " + v));
    }


    /**
     * 生成嵌套map,形如 Map<String, Map<String, List<String>>>
     * 注意 预防空
     https://stackoverflow.com/questions/47868865/nullpointerexception-element-cannot-be-mapped-to-a-null-key?noredirect=1&lq=1

     */
    @Test
    public void testTwoNestMap(){
//        List<Person> list = javaProgrammers;
//        Function<Person, String> lineMapper = o -> o.getGender();
//        // 注意 预防空
//        Function<Person, String> flightNoMapper = o -> StringUtils.defaultIfBlank(o.getLastName(), "");
//        Function<Person, String> goDateMapper = (s) -> s.getFirstName();
//        Collector<Person, ?, List<String>> mapping = Collectors.mapping(goDateMapper, Collectors.toList());
//        Map<String, Map<String, List<String>>> collect = list.stream().collect(Collectors.groupingBy(lineMapper, Collectors.groupingBy(flightNoMapper, mapping)));
//        System.out.println("collect = " + JSON.toJSONString(collect));
    }

    /**
     * 生成嵌套map,形如 Map<String, Map<String, List<String>>>
     * todo 但是list 是其他函数提供的
     * 这个暂时未完成
     * 1 按照 性别, 姓氏 分组,  Map<String, Map<String, List<String>>>
     * 2 分组后的list 对应从getDays获取
     */
    @Test
    public void testTwoNestMapOther(){

        Supplier<List<String>> supplier = this::getDays;

        List<Person> list = javaProgrammers;
        Function<Person, String> lineMapper = o -> o.getGender();
        // 注意 预防空
        Function<Person, String> flightNoMapper = o -> StringUtils.defaultIfBlank(o.getLastName(), "");
//        Function<Person, String> goDateMapper = (s) -> s.getFirstName();
//        Collector<Person, ?, List<String>> mapping = Collectors.mapping(goDateMapper, Collectors.toList());


        Function<Person, List<String>> goDateMapper = (s) -> getDays();

        Collector<Person, ?, List<String>> mapping = Collectors.mapping(goDateMapper, Collector.of(ArrayList::new, List::addAll,
                (left, right) -> { left.addAll(right); return left; }));


        Map<String, Map<String, List<String>>> collect = list.stream().collect(Collectors.groupingBy(lineMapper, Collectors.groupingBy(flightNoMapper, mapping)));
        System.out.println("collect = " + JSON.toJSONString(collect));

    }

    public  List<String> getDays() {

        return Lists.newArrayList("2019-04-05");
    }
}
