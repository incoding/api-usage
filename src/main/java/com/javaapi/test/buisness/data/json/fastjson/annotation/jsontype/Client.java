package com.javaapi.test.buisness.data.json.fastjson.annotation.jsontype;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.javaapi.test.buisness.constant.constant.classconstant.ConstantGame;
import com.javaapi.test.buisness.data.json.fastjson.util.JsonUtil;
import org.junit.Test;

/**
 * Created by user on 18/4/5
 */
public class Client {
    /**
     * 直接给类 设置@JsonType 注解, 告知使用某个serialize, deserialize
     */
    @Test
    public void testSerialize() {
        String string = getJson();
        System.out.println("string = " + string);
    }

    @Test
    public void testDeserialize() {
        String json = getJson();
        System.out.println("json = " + json);
        Student object = JsonUtil.getObject(json);
        System.out.println("object = " + object);
    }

    private String getJson() {
        Student student = new Student();
        student.setName("hello jsontype");
        student.setConstantGame(ConstantGame.CYHX);
        return JSON.toJSONString(student, SerializerFeature.WriteClassName);
    }
}
