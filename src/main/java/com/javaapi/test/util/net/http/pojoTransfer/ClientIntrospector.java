package com.javaapi.test.util.net.http.pojoTransfer;

import com.javaapi.test.util.opensource.apache.commons.beanutils.pojo.StrangePojo;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * refer https://www.cnblogs.com/dreammyle/p/5610906.html
 * Created by user on 18/3/26
 */
public class ClientIntrospector {
    @Test
    public void test(){

    }

    /**
     * 单个字符的字段  大D会被描述为小d
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

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            Method setter = property.getWriteMethod();
            if (setter != null) {
                setter.invoke(obj, map.get(property.getName()));
            }
        }

        return obj;
    }

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null ? getter.invoke(obj) : null;
            map.put(key, value);
        }

        return map;
    }
}
