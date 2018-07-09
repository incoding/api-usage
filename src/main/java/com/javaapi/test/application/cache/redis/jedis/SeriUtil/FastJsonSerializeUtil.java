package com.javaapi.test.application.cache.redis.jedis.SeriUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;


public class FastJsonSerializeUtil {
    public static byte[] serialize(Object object) {
        if(object == null){
            return null;
        }
        SerializerFeature[] features = new SerializerFeature[0];
        SerializeWriter out = new SerializeWriter();

        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (com.alibaba.fastjson.serializer.SerializerFeature feature : features) {
                serializer.config(feature, true);
            }

            serializer.write(object);
            return out.toBytes("UTF-8");
        } finally {
            out.close();
        }
    }


    public static <T> Object deserialize(byte[] bytes, Class<T> clazz) {
        Object parse = JSON.parseObject(bytes, clazz);
        return parse;
    }
    public static <T> List<T> deserializeArray(byte[] bytes, Class<T> clazz) {
        List<T> parse = JSON.parseArray(new String(bytes), clazz);
        return parse;
    }
}
