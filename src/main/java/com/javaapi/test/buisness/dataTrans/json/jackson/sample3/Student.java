package com.javaapi.test.buisness.dataTrans.json.jackson.sample3;

import java.util.Date;

public class Student {
    private int id;
    private Name name;
    private String className;
    private Date birthDay;
    public Student(){}
    public Student(int id, Name name, String className, Date birthDay) {
        super();
        this.id = id;
        this.name = name;
        this.className = className;
        this.birthDay = birthDay;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    @Override
    public String toString() {
        return "Student [birthDay=" + birthDay + ", id=" + id + ", name=" + name + ", classname="+ className + "]";
    }
}