package com.javaapi.test.buisness.constant.constant.classconstant.jsonSerialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.javaapi.test.buisness.constant.constant.classconstant.ConstantGame;
import com.javaapi.test.buisness.constant.constant.classconstant.Student;
import org.junit.Test;

/**
 * Created by user on 18/3/11.
 */
public class Client {
    @Test
    public void testSer(){
        String s1 = getJson();
        System.out.println("s1 = " + s1);
    }

    /**
     * 反序列化会报错, TODO 暂时未解决
     */
    @Test
    public void testDeSerialize(){
        String s1 = getJson();
        ParserConfig parserConfig = new ParserConfig();
        parserConfig.putDeserializer(ConstantGame.class,new ConstantGameDeserializer());
        Student student = JSON.parseObject(s1, Student.class,parserConfig);
        System.out.println("s1 = " + student);
    }

    private String getJson() {
        Student s = new Student();
        s.setAge(30);
        s.setName("testSerialize");
        s.setConstantGame(ConstantGame.SJ);
        SerializeConfig serializeConfig = new SerializeConfig();
        serializeConfig.put(ConstantGame.class, new ConstantGameSerializer());
        return JSON.toJSONString(s, serializeConfig);
    }
}
