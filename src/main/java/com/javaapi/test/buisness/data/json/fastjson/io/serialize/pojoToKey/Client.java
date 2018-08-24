package com.javaapi.test.buisness.data.json.fastjson.io.serialize.pojoToKey;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.buisness.constant.constant.classconstant.ConstantGame;
import com.javaapi.test.buisness.data.json.fastjson.io.serialize.pojoToKey.pojo.Student;
import org.junit.Test;

/**
 * Created by user on 18/4/4
 */
public class Client {

    /**
     * 默认是按照json输出
     */
    @Test
    public void test(){
        Student student = new Student();
        student.setName("nihao2");
        student.setGame(ConstantGame.CYHX);
        String string = JSON.toJSONString(student);
        System.out.println("string = " + string);
    }

    /**
     * 想把普通json只输出成一个 key,需要特别定制序列化
     */
    @Test
    public void testSer(){

    }

}
