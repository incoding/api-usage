package com.javaapi.test.test.javafeature.oop.miscell;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void getPersonThis() {
        System.out.println(Person.this);
    }
    // 会报错
    //    public void getTeacherThis() {
    //        System.out.println(Teacher.this.toString());
    //    }
}
