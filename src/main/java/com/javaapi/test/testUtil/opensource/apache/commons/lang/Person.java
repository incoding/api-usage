package com.javaapi.test.testUtil.opensource.apache.commons.lang;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

/**
 * Created by user on 15/8/16.
 */
public class Person {
    private String name;
    private String age;
    private List<Person> list ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .append("name", name)
//                .append("age", age)
//                .toString();
//    }

//    @Override
//    public String toString() {
//        return Objects.toStringHelper(this)
//                .add("name", name)
//                .add("age", age)
//                .toString();
//    }

    @Override
    public String toString() {
        String s = ReflectionToStringBuilder.toString(this);
        return s;
    }
}
