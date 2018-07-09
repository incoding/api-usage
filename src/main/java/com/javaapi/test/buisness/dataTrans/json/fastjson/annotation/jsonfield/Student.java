package com.javaapi.test.buisness.dataTrans.json.fastjson.annotation.jsonfield;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by user on 18/4/6
 * 不需要的 get方法用 jsontype 忽略掉
 */
@JSONType(ignores = {"haha"})
public class Student {
    @JSONField(name="NAME")
    private String name;

    private int age;

    public String getName() {
        return "getter modify name";
    }

    public void setName(String name) {
        name = "setter modify  name";
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHaha(){
        return "other getter";
    }

    public  String setHaha(){
        return "222";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }


}
