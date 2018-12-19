package com.javaapi.test.test.reflect.classScan;

import com.javaapi.test.test.reflect.classScan.annotation.Define;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientScan {

    private Map<String, Field> fieldMap = new HashMap<>();

    @Test
    public void test() {
        String packageName = "com.javaapi.test.test.testReflect.classScan";
        List<Class<?>> classes = ClassUtil.getClasses(packageName);
        scanClassForField(classes);
        System.out.println("classes = " + fieldMap);
    }

    private void scanClassForField(List<Class<?>> classes) {
        for (Class<?> aClass : classes) {
            Field[] declaredFields = aClass.getDeclaredFields();
            scanField(declaredFields);
        }
    }

    private void scanField(Field[] declaredFields) {
        for (Field field : declaredFields) {
            if (!field.isAnnotationPresent(Define.class)) {
                continue;
            }
            fieldMap.put(field.getName(), field);
        }
    }


}
