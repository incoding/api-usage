package com.javaapi.test.buisness.dataTrans.json.fastjson.SerDeser.serialize.enumToJson.part;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.junit.Test;

/**
 * https://github.com/alibaba/fastjson/wiki/%E5%AE%9A%E5%88%B6%E5%BA%8F%E5%88%97%E5%8C%96
 * 序列化的时候,只序列化enum 的某个字段
 * 反序列化的时候,只反序列化enum 的某个字段
 */
public class Client {
    @Test
    public void testSerialize() {
        String jsonStr = getJson();
        System.out.println("jsonStr = " + jsonStr);
    }

    @Test
    public void testDeserialize() {
        String json = getJson();
        ParserConfig parserConfig = new ParserConfig();
        parserConfig.putDeserializer(Status.class,new StatusDeserializer());
        Student student = JSON.parseObject(json, Student.class,parserConfig);
        System.out.println("student = " + student);
    }

    private String getJson() {
        SerializeConfig config = new SerializeConfig();
        config.put(Status.class, new StatusSerializer());

        Student student = new Student();
        student.setName("nihao");
        student.setStatus(Status.Ready);
        return JSON.toJSONString(student, config);
    }
}
