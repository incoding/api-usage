package com.javaapi.test.buisness.data.json.fastjson.feature.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.javaapi.test.buisness.data.json.fastjson.annotation.jsontype.Student;
import com.javaapi.test.buisness.joint.outter.Result;
import org.junit.Test;
import org.testng.collections.Lists;

import java.lang.reflect.Type;
import java.util.List;

public class Client2 {
    @Test
    public void test(){
        Object result = parseListResult(getJson(), Student.class);
        System.out.println("result = " + result);
    }

    public static String getJson(){
        Student student = new Student();
        student.setName("this is name");
        Result<List<Student>> success = Result.success(Lists.newArrayList(student));
        return JSON.toJSONString(success);
    }

    private static <T> Result<List<T>> parseListResult(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, buildType(Result.class, List.class, clazz));
    }

    private static Type buildType(Type... types) {
        ParameterizedTypeImpl beforeType = null;
        if (types != null && types.length > 0) {
            for (int i = types.length - 1; i > 0; i--) {
                beforeType = new ParameterizedTypeImpl(new Type[]{beforeType == null ? types[i] : beforeType}, null, types[i - 1]);
            }
        }
        return beforeType;
    }
}
