package com.javaapi.test.buisness.data.json.fastjson.SerDeser.serialize.enumToJson.total;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.javaapi.test.buisness.data.json.fastjson.SerDeser.serialize.enumToJson.part.Status;
import com.javaapi.test.buisness.data.json.fastjson.SerDeser.serialize.enumToJson.part.Student;
import org.junit.Test;

/**
 * https://www.cnblogs.com/VergiLyn/p/6753706.html
 */
public class Client {

    /**
     * configEnumAsJavaBean   可以直接将枚举序列化成json
     */
    @Test
    public void testSer() {
        Student student = new Student();
        student.setName("nihaoa");
        student.setStatus(Status.Ready);
        SerializeConfig config = new SerializeConfig();
        // 枚举 要有get和set
        config.configEnumAsJavaBean(Status.class);
        String s = JSON.toJSONString(student, config);
        System.out.println("s = " + s);
    }

    /**
     * 反序列化 暂时没找到方便的方式
     * 可以用 part 里的来反序列化
     */
    @Test
    public void testDeSer() {
        String string = "{\"name\":\"nihaoa\",\"status\":{\"value\":10}}";
        ParserConfig parserConfig = new ParserConfig();
    }
}
