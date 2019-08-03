package com.javaapi.test.test.misc.refactor.eclipseRefactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class SubClass extends SuperClass {
    private static Vector users = new Vector();

    public void saySub() {
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
}
