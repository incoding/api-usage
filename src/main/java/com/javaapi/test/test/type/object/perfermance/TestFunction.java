package com.javaapi.test.test.type.object.perfermance;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.javaapi.test.test.type.object.FromBean;

public class TestFunction {
    @Test
    public void testBeanToMap() {
        FromBean fb = new FromBean();
        fb.setAddress("北京市朝阳区大屯路");
        fb.setAge(20);
        fb.setMoney(30000.111);
        fb.setIdno("110330219879208733");
        fb.setName("测试");
        Map<String,String> map =new HashMap<>();
        BeanUtils.copyProperties(fb, map);
        // 不可以copy到map
        System.out.println(map);
    }
    @Test
    public void testMapToBean() {
        FromBean fb = new FromBean();
        Map<String,String> map =new HashMap<>();
        map.put("address", "北京市朝阳区大屯路");
        BeanUtils.copyProperties(map, fb);
        // 不可以map to bean
        System.out.println(fb);
    }
    /**
     * apache commons可以
     */
    @Test
    public void testMapToBean2() {
        FromBean fb = new FromBean();
        Map<String,String> map =new HashMap<>();
        map.put("address", "北京市朝阳区大屯路");
        try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(fb, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(fb);
    }
    @Test
    public void testMapToBean3() {
        FromBean fb = new FromBean();
        System.out.println(fb);
    }
}
