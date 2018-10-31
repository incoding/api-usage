package com.javaapi.test.buisness.data.json.fastjson.annotation.jsonfield.format;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;

/**
 * Created by user on 2018/10/1
 */
public class Client {
    @Test
    public void test(){
        Father father = new Father();
        father.setAge(new Date());
        System.out.println("father = " + JSON.toJSONString(father));
    }

    @Test
    public void testSon(){
        Son son = new Son();
        son.setAge(new Date());
        System.out.println("father = " + JSON.toJSONString(son));
    }

}
