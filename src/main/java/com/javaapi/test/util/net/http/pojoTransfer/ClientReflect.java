package com.javaapi.test.util.net.http.pojoTransfer;

import com.javaapi.test.util.opensource.apache.commons.beanutils.pojo.StrangePojo;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 18/3/26
 */
public class ClientReflect {

    /**
     * 这种方式 大D可以正常显示
     * 单个字符的字段  大D正常显示
     */
    @Test
    public void describeStrange(){
        StrangePojo strangePojo = new StrangePojo();
        strangePojo.setD("da D");
//        strangePojo.setDd("daxiao Dd");
        strangePojo.setDD("da DD");
//        strangePojo.setd("xiao d");
        describe(strangePojo);

    }

    private void describe(Object student) {
        try {
            Map<String, Object> describe = objectToMap(student);
            System.out.println("describe = " + describe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }

        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }

            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }

        return obj;
    }

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null){
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }
}
