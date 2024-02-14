package com.javaapi.test.buisness.data.json.fastjson.feature.generic;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.javaapi.test.buisness.joint.outter.Result;

import java.lang.reflect.Type;
import java.util.List;

/**
 * json支持泛型反序列化
 */
@SuppressWarnings("all")
public class JsonGenericUtil {

    public static <T> Result<List<T>> parseListResult(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, buildType(Result.class, List.class, clazz));
    }

    public static  <T> T parseGeneric(String json, Class[] clazz){
        return JSONObject.parseObject(json, buildType(clazz));
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
