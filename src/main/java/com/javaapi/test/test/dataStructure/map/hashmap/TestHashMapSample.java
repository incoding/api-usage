package com.javaapi.test.test.dataStructure.map.hashmap;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestHashMapSample {

    @Test
    public void test(){
        Person person = new Person();
        person.setAge(28);
        person.setName("nihao");
        person.setId(1);

        ArrayList<Person> objects = Lists.newArrayList();
        objects.add(person);

        ArrayList<Person> object2 = Lists.newArrayList();
        object2.add(person);


        HashMap<Integer, Person> map = new HashMap<>();
        map.put(object2.get(0).getId(), object2.get(0));

        // 在1 中修改
        objects.get(0).setName("nihao_now");


        System.out.println("object2 = " + object2);
        System.out.println("map = " + map);


    }

    public static class Person{
        private Integer id;
        private String name;
        private Integer age;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append('}');
            return sb.toString();
        }
    }

}
