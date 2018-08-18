package com.javaapi.test.application.cache.redis.jedis.SeriUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class JacksonSerializeUtil {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static byte[] serialize(Object object) {
        if(object == null){
            return null;
        }
        byte[] bytes = null;
        try {
            bytes = MAPPER.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  bytes;
    }
    public static <T> Object deserialize(byte[] bytes, Class<T> clazz) {
        if (bytes == null) {
            return null;
        }
        if(clazz == null){
            return null;
        }
        Object parse = null;
        try {
            parse = MAPPER.readValue(bytes, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parse;
    }
    public static <T> List<T> deserializeArray(byte[] bytes,Class<T> clazz) {
        if (bytes == null) {
            return null;
        }
        if(clazz == null){
            return null;
        }
        List<T> parse = null;
        try {
            parse = MAPPER.readValue(bytes,getCollectionType(ArrayList.class,clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
