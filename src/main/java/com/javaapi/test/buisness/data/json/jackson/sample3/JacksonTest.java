package com.javaapi.test.buisness.data.json.jackson.sample3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class JacksonTest {
    public static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        //设置将对象转换成JSON字符串时候:包含的属性不能为空或"";
        //Include.Include.ALWAYS 默认
        //Include.NON_DEFAULT 属性为默认值不序列化
        //Include.NON_EMPTY 属性为 空（""）  或者为 NULL 都不序列化
        //Include.NON_NULL 属性为NULL 不序列化
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //设置将MAP转换为JSON时候只转换值不等于NULL的
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //设置有属性不能映射成PO时不报错
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }
    public static void main(String[] args) throws Exception{
        //准备数据
        Name name1 = new Name("zhang","san");
        Name name2 = new Name("li","si");
        Name name3 = new Name("wang","wu");
        Student student1 = new Student(1,name1,"一班",new Date());
        Student student2 = new Student(2,name2,"二班",new Date());
        Student student3 = new Student(3,name3,"三班",new Date());
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Map<String,Student> studentMap = new HashMap<String, Student>();
        studentMap.put("1", student1);
        studentMap.put("2", student2);
        studentMap.put("3", student3);
        Student json2object = null;
        List<Student> json2list = null;
        Map<String,Student> json2map = null;
        ObjectMapper mapper = getDefaultObjectMapper();
         //        // 写的时候很方便不用特别处理

        /* Object --> JSON */
        String object4json = mapper.writeValueAsString(student1);
        System.out.println("Object ----> JSON");
        System.out.println(object4json);
        System.out.println("------------------------------------------------------");

        /* List<Object> --> JSON */
        String listforjson = mapper.writeValueAsString(studentList);
        System.out.println("List<Object> ----> JSON");
        System.out.println(listforjson);
        System.out.println("------------------------------------------------------");

        /* Map<String,Object> ----> JSON */
        String map4json = mapper.writeValueAsString(studentMap);
        System.out.println("Map<String,Object> ----> JSON");
        System.out.println(map4json);
        System.out.println("------------------------------------------------------");





        // 读的时候如果有泛型需要小小的特别处理一下
        /* JSON --> Object */
        json2object = mapper.readValue(object4json, Student.class);
        System.out.println("JSON ----> Object");
        System.out.println(json2object);
        System.out.println("------------------------------------------------------");
        /* JSON --> List<Object> */
        json2list = mapper.readValue(listforjson, new TypeReference<List<Student>>() {});
        System.out.println("JSON --> List<Object>");
        System.out.println(json2list.toString());
        System.out.println("------------------------------------------------------");
        /* JSON --> Map<String,Object> */
        json2map = mapper.readValue(map4json, new TypeReference<Map<String,Student>>() {});
        System.out.println("JSON --> Map<String,Object>");
        System.out.println(json2map.toString());
    }
    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper mapper = getDefaultObjectMapper();
        Name name1 = new Name("zhang","san");
        Name name2 = new Name("li","si");
        Name name3 = new Name("wang","wu");
        Student student1 = new Student(1,name1,"一班",new Date());
        Student student2 = new Student(2,name2,"二班",new Date());
        Student student3 = new Student(3,name3,"三班",new Date());
        String s1 = mapper.writeValueAsString(student3);
        System.out.println("s1 = " + s1);

        // 写的时候很方便不用特别处理
        Teacher<String> nihao = new Teacher<>();
        nihao.setT("nihao");
        String s = mapper.writeValueAsString(nihao);
        System.out.println("s = " + s);


    }
}