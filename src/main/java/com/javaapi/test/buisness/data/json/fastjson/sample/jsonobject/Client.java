package com.javaapi.test.buisness.data.json.fastjson.sample.jsonobject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Created by user on 2019/1/3
 */
public class Client {
    @Test
    public void test(){
        String s = "{'name':'nihao'}";
        JSONObject jsonObject = JSON.parseObject(s);
        String name = jsonObject.getString("name");
        System.out.println("name = " + name);

    }
}
