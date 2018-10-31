package com.javaapi.test.buisness.data.json.fastjson.annotation.jsonfield.format;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by user on 2018/10/1
 */
public class Son extends Father{

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date age;


    @Override
    public Date getAge() {
        return age;
    }
    @Override
    public void setAge(Date age) {
        this.age = age;
    }
}
