package com.javaapi.test.buisness.data.json.fastjson.pojo.bean;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Created by user on 2018/8/27
 */
public class ClientSchool {
    @Test
    public void testWriteIs(){
        School School = new School();
        School.setName("nihao");
        School.setPass(true);
        String s = JSON.toJSONString(School);
        System.out.println("s = " + s);
    }

    @Test
    public void testReadNotContainsIs(){
        String s = "{\"name\":\"nihao\",\"pass\":true}";
        School School = JSON.parseObject(s, School.class);
        System.out.println("School = " + School);
    }

    @Test
    public void testReadContainsIs(){
        String s = "{\"name\":\"nihao\",\"isPass\":true}";
        School School = JSON.parseObject(s, School.class);
        System.out.println("School = " + School);
    }
}
