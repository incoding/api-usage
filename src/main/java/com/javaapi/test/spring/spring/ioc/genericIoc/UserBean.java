package com.javaapi.test.spring.spring.ioc.genericIoc;

/**
 * Created by user on 2018/11/25
 */

public class UserBean {

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    String name;
    int age;
    public UserBean(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public UserBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "UserBean [name=" + name + ", age=" + age + "]";
    }

}