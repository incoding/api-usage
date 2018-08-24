package com.javaapi.test.spring.ioc.xml.xmlioc;


public class People {
    private String name;
    private String age;


    public People(String nameAndAge) {
        if (nameAndAge == null || nameAndAge.isEmpty()) {
            return;
        }
        String[] info = nameAndAge.split(":");
        if (info.length < 2) {
            return;
        }
        this.name = info[0];
        this.age = info[1];
    }

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

    @Override
    public String toString() {
        return "People [name=" + name + ", age=" + age + "]";
    }

}
