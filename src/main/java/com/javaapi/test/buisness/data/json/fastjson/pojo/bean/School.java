package com.javaapi.test.buisness.data.json.fastjson.pojo.bean;

/**
 * Created by user on 2018/8/27
 */
public class School {
    private String name;
    private boolean pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("School{");
        sb.append("name='").append(name).append('\'');
        sb.append(", pass=").append(pass);
        sb.append('}');
        return sb.toString();
    }
}
