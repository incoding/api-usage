package com.javaapi.test.eclipseRefactor;

import java.util.ArrayList;
import java.util.HashMap;

public class SuperClass {

    public static void saySubOther() {
        HashMap resources = new HashMap();
        resources.put("key", new ArrayList<String>());
        System.out.println("i am sub class");
        try {
            throw new ReflectiveOperationException();
        } catch (ReflectiveOperationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void saySuper() {
        System.out.println("i am super class");
    }
}
