package com.javaapi.test.buisness.dataTrans.json.fastjson.util;

import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Client {

    public static class Person{
        private int id;
        private boolean ok;
        private boolean isOk;
        private Boolean wrong;

        public Person() {
        }



        public Person(boolean ok, Boolean wrong) {
            this.ok = ok;
            this.wrong = wrong;
        }

        public boolean getOk() {
            return ok;
        }

        public void setOk(boolean ok) {
            this.ok = ok;
        }

        public Boolean getWrong() {
            return wrong;
        }

        public void setWrong(Boolean wrong) {
            this.wrong = wrong;
        }
    }

    @Test
    public void test(){
        Person person = new Person(true, true);
        String json = JsonUtil.json(person);
        System.out.println("json = " + json);
    }

    @Test
    public void test2(String[] args) throws IOException {
        String jsonString = "{\"nihao\":123}";
        String jsonString2 = "{\"nihao\":[123,123]}";
        String jsonString3 = "{\"nihao\":{\"nihao2\":223}}";
        Map<String, String> map = JsonUtil.getMap(jsonString);
        Map<String, List<String>> mapList = JsonUtil.getMap(jsonString2);
        Map<String, Map<String,Object>> mapMap = JsonUtil.getMap(jsonString3);
        System.out.println(map);
        System.out.println(mapList);
        System.out.println(mapMap);
        Map<String, Object> map2 = mapMap.get("nihao");
        System.out.println(map2);
        System.out.println(map2.get("nihao2"));
        System.out.println("------------------------");
        String jsonArr= "[1,2,3,4,5]";
        List<String> list = JsonUtil.getList(jsonArr);
        System.out.println(list);
        System.out.println("------------------------");
        String objectString = "{\"nihao\":123}" ;
        @SuppressWarnings("unchecked")
        Map<String,Object> object = JsonUtil.getObject(objectString, Map.class);
        System.out.println(object);
        System.out.println(object.get("nihao"));
        @SuppressWarnings("unchecked")
        Map<String, Map<String,Object>> mapMap2 = JsonUtil.getObject("sdf", LinkedHashMap.class);
        System.out.println(mapMap2);
        System.out.println("-------------");
        String json = JsonUtil.json(mapMap);
        System.out.println(json);
    }

}
