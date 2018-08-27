package com.javaapi.test.buisness.data.json.fastjson.pojo.bean;

/**
 * Created by user on 2018/8/27
 */
public class Student {
    private String name ;
    private boolean isPass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", isPass=").append(isPass);
        sb.append('}');
        return sb.toString();
    }
}
