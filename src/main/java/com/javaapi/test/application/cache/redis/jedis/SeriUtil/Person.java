package com.javaapi.test.application.cache.redis.jedis.SeriUtil;

import java.io.Serializable;

/**
 * Created by user on 15/8/23.
 */
public class Person implements Serializable {
    private int id;
    private String name;

    public Person(){

    }
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}