package com.javaapi.test.buisness.data.json.fastjson.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class JsonUtil {
    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }
    
    public static String json(Object object){
        if(object == null){
            return "{}";
        }
        
        String jsonString = "";
        try {
            jsonString = JSON.toJSONString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static String jsonWithType(Object object){
        if(object == null){
            return "{}";
        }

        String jsonString = "";
        try {
            jsonString = JSON.toJSONString(object,SerializerFeature.WriteClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }


    /**
     * 将java对象转换成json字符串
     *
     * @param <T>
     * @param t
     *          java对象
     * @return
     */
    public static <T> String pojoToJsonString(T t) {
        String jsonStr = JSON.toJSONString(t);
        return jsonStr;
    }

    /**
     * 将含有时间属性的java对象转换成json字符串
     *
     * @param <T>
     * @param t
     *          java对象
     * @param DateFormate
     *          时间 格式
     * @return
     */
    public static <T> String pojoToJsonString(T t, String DateFormate) {
        // TODO UseISO8601DateFormat？
        String jsonStr = JSON.toJSONStringWithDateFormat(t, DateFormate,
                SerializerFeature.UseISO8601DateFormat);
        return jsonStr;
    }
    

    public static <T> T getObject(String jsonString, Class<T> temp) {
        T parseObject = null;
        try {
            parseObject = JSON.parseObject(jsonString, temp);
        } catch (Exception e) {
            T newInstance = null;
            try {
                newInstance = temp.newInstance();
            } catch (Exception e1) {
                e1.printStackTrace();
            } 
            return newInstance;
        }
        return parseObject;
    }


    /**
     * 写的使用使用 JsonUtil.jsonWithType(Object object)
     * 则 读的时候可以使用 JsonUtil.getObject(String jsonString)
     * @param jsonString
     * @param <T>
     * @return
     */
    public static <T> T getObject(String jsonString) {
        T parseObject = null;
        try {
            parseObject = (T) JSON.parse(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return parseObject;
    }
    
    /**
     *
     *传入符合规范的json
     */
    public static  <K, V> Map<K, V>  getMap(String jsonString){
        if(jsonString == null || jsonString.trim() == ""){
            return new HashMap<K,V>();
        }
        Map<K, V>  parseObject;
        try {
            parseObject =  JSON.parseObject(jsonString, new TypeReference<Map<K, V>>(){},Feature.AllowUnQuotedFieldNames,Feature.AllowSingleQuotes);
        } catch (Exception e) {
            parseObject = new HashMap<K,V>();
        }
        return parseObject;
    }
    /**
     *
     *传入符合规范的json
     */
    public static  <T> List<T>  getList(String jsonString){
        if(jsonString == null || jsonString.trim() == ""){
            return new ArrayList<T>();
        }
        List<T> parseObject;
        try {
            parseObject =  JSON.parseObject(jsonString, new TypeReference<List<T>>(){},Feature.AllowUnQuotedFieldNames,Feature.AllowSingleQuotes);
        } catch (Exception e) {
            parseObject = new ArrayList<T>();
        }
        return parseObject;
    }
}