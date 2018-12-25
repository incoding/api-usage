package com.javaapi.test.buisness.data.json.fastjson.sample.jsonarray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.testng.collections.Lists;

/**
 * Created by user on 2018/12/24
 */
public class Client {
    @Test
    public void test(){
        String s = "{\"students\":[{\"name\":\"charles\",\"age\":18},{\"name\":\"kevin\",\"age\":22}]}";
        JSONObject out = JSON.parseObject(s);
        System.out.println("students = " + out);
        JSONArray students = out.getJSONArray("students");
        for (int i = 0; i < students.size(); i++) {
            JSONObject in = students.getJSONObject(i);
            JSONObject jsonObject = (JSONObject) out.clone();
            jsonObject.put("students", Lists.newArrayList(in));
            System.out.println("out = " + out.toString());
            System.out.println("in = " + jsonObject.toString());
        }

    }
}
