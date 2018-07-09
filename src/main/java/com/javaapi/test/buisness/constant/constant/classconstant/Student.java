package com.javaapi.test.buisness.constant.constant.classconstant;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private ConstantGame constantGame;
    private String name;
    private String id;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [constantGame=" + constantGame + ", name=" + name + ", id=" + id + ", age=" + age + "]";
    }

    public ConstantGame getConstantGame() {
        return constantGame;
    }

    public void setConstantGame(ConstantGame constantGame) {
        this.constantGame = constantGame;
    }

}