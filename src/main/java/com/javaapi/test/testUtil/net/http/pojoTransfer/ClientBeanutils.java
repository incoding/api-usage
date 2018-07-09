package com.javaapi.test.testUtil.net.http.pojoTransfer;

import org.junit.Test;

import java.util.Map;

/**
 * map To Object
 * @see com.javaapi.test.testUtil.opensource.apache.commons.beanutils.ClientDescribe
 */
public class ClientBeanutils {
    @Test
    public void test(){

    }

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }

        Object obj = beanClass.newInstance();

        org.apache.commons.beanutils.BeanUtils.populate(obj, map);

        return obj;
    }

    public static Map<?, ?> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }

        return new org.apache.commons.beanutils.BeanMap(obj);
    }
}
