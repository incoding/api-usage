package com.javaapi.test.buisness.joint.result.base;

import java.io.Serializable;

/**
 * Created by user on 2019/3/5
 */
public class ResultModel implements Serializable {
    private Integer id;
    private String name;

    public ResultModel() {
    }

    public ResultModel(String name) {
        this.name = name;
    }

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
}
