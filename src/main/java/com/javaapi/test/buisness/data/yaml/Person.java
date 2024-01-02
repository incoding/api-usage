package com.javaapi.test.buisness.data.yaml;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Person {
    private Integer id;
    private String name;
    private int age;
    private String Sex;
    private List<Person> children;
    private Map<String, String> iotOpenResopnse = new HashMap<>();
}