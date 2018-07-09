package com.javaapi.test.buisness.constant.constant.enumconstant.enumSerDeser;

import java.io.Serializable;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    State state;
    String name;
    String id;
    int age;

    public void setState(State state) {
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("state:").append(state != null ? state.getValue() : "error").append(" ");
        str.append("name:" + name).append(" ");
        str.append("age:" + age).append(" ");
        str.append("id:" + id);
        return str.toString();
    }

    public State getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}