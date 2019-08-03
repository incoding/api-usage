package com.javaapi.test.buisness.data.json.fastjson.sample.sample2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.javaapi.test.buisness.data.json.fastjson.pojo.generic.Withdraw;
import com.javaapi.test.buisness.data.json.fastjson.pojo.generic.WithdrawVo;
import com.javaapi.test.spring.spring.ioc.xml.Student;
import jodd.io.FileUtil;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.数组或对象的每个成员的值，可以是简单值，也可以是复合值。</br>
 * <p>
 * 2.简单值分为四种：字符串、数值（必须以十进制表示）、布尔值和null。</br>
 * <p>
 * 3.复合值分为两种：符合JSON格式的对象和符合JSON格式的数组。</br>
 * <p>
 * 4.数组或对象最后一个成员的后面，不能加逗号。</br>
 * <p>
 * 5.数组或对象之中的字符串必须使用双引号，不能使用单引号。</br>
 * <p>
 * 6.<span style="color:red">对象的成员名称</span>必须使用<span style="color:red">双引号</span>。</br>
 * </br>
 * 主要api
 * <code>
 * public abstract class JSON {
 * public static final String toJSONString(Object object);
 * public static final <T> T parseObject(String text, Class<T> clazz, Feature... features);
 * }
 * </code>
 */
public class TestFastJson {
    @Test
    public void serialize() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1", "2");
        map.put("2", "2");
        map.put("3", "2");
        map.put("number", 1);
        map.put("number2", 2);
        map.put("number3", 3);
        map.put("null", 1);
        map.put("booleanTrue", true);
        map.put("booleanFalse", false);
        System.out.println("默认情况下");
        System.out.println(JSON.toJSON(map).toString());
        System.out.println("UseSingleQuotes");
        System.out.println(JSON.toJSONString(map,
                SerializerFeature.UseSingleQuotes));
    }

    @Test
    public void deserialize() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "2");
        map.put("2", "2");
        map.put("3", "2");
        String jsonString = JSON.toJSON(map).toString();
        // @SuppressWarnings("unchecked")
        // HashMap<String, String> hashmap = JSON.parseObject(jsonString,
        // HashMap.class);
        // 传入类型参数
        Map<String, String> hashmap = JSON.parseObject(jsonString,
                new TypeReference<Map<String, String>>() {
                }, Feature.AllowUnQuotedFieldNames);
        System.out.println(hashmap);
    }

    @Test
    public void deserializeToMapDeep() throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String jsonString = FileUtil.readString("/home/kk/static/no_cache/jc/dcsf/data/conf_470.js", CharEncoding.UTF_8);
//        JSONObject.parseObject(jsonString,Map.class);
        Map<String, Object> hashmap = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>() {
        }, Feature.AllowUnQuotedFieldNames);

        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }

    @Test
    public void testMap2Object() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("index", "2");
        map.put("desc", "333");
        JSONObject json = new JSONObject();
        json.putAll(map);
        Withdraw javaObject = JSONObject.toJavaObject(json, Withdraw.class);
        System.out.println(javaObject);
    }

    @Test
    public void testObject2Map() throws Exception {
        Withdraw withdraw = new Withdraw();
        withdraw.setIndex_index("222");
        withdraw.setDesc("nihao");
        String jsonString = JSONObject.toJSONString(withdraw);
        Map<String, String> javaObject = JSON.parseObject(jsonString, Map.class);
        System.out.println(javaObject);
    }

    @Test
    public void deserializeToMapJsonLib() throws IOException {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        for (int i = 0; i < 5000; i++) {
//            String jsonString = FileUtil.readString("/home/kk/static/no_cache/jc/dcsf/data/conf_470.js",CharEncoding.UTF_8);
//            // 传入类型参数
//            JSONObject hashmap = JSONObject.fromObject(jsonString);
////            hashmap.toString();
////            System.out.println(i);
//        }
//        stopWatch.stop();
//        System.out.println(stopWatch.getTime());
    }

    @Test
    public void testLowerCase() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("NIHAO", "NIHSS");
        WithdrawVo<Map<String, String>> wo = new WithdrawVo<>();
        wo.setDATA(map);
        wo.setRESULT("success");
//		System.out.println(JSON.toJSONString(wo));
        TypeUtils.compatibleWithJavaBean = true;
        System.out.println(JSON.toJSONString(wo));
    }

    @Test
    public void parseNull() throws Exception {
        JSONObject parseObject = JSON.parseObject(null);
        System.out.println(parseObject);
        Boolean boolean1 = parseObject.getBoolean("isSuccess");
        System.out.println(boolean1);
    }

    @Test
    public void testListMap() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("nihao", "nihao");
        list.add(map);
        list.add(new HashMap<>(map));
        String s = JSON.toJSONString(list);
        System.out.println("s = " + s);
    }

    @Test
    public void testJsonArr() {
        String s = "[]";
        JSONArray parse = (JSONArray) JSONArray.parse(s);
        System.out.println("parse = " + parse.toJSONString());
        System.out.println("parse = " + parse.size());
    }

    @Test
    public void testJsonObjectOrJsonArr() {
    }

    @Test
    public void testString(){
        String a = "nihao";
        String s = JSON.toJSONString(a);
        System.out.println("s = " + s);
    }

    @Test
    public void testStringEmpty(){
        String a = "";
        Student student = JSON.parseObject(a, Student.class);
        System.out.println("student = " + student);
    }

    @Test
    public void testString2() {
        String s1 = JSON.toJSONString("");
        System.out.println("true = " + s1);

        Object sObject1;
        sObject1 = JSON.parseObject(s1, Object.class);
        System.out.println("sObject = " + sObject1);

        System.out.println("----------- = ");

        String s = JSON.toJSONString(null);
        System.out.println("true = " + s);

        Object sObject = JSON.parseObject(s, Object.class);
        System.out.println("sObject = " + sObject);

        System.out.println("----------- = ");

        String s2 = "{}";
        Withdraw sObject2 = JSON.parseObject(s2, Withdraw.class);

        System.out.println("true = " + sObject2);
    }

}
