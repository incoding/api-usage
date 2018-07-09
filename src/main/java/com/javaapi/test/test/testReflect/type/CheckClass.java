package com.javaapi.test.test.testReflect.type;

import java.util.ArrayList;

public class CheckClass {
public static void main(String[] args) {
	String s=new String("javaisland");
    System.out.println(s instanceof String); //true
    String s2=new String("javaisland");
    System.out.println(String.class.isInstance(s2)); //true
    System.out.println(ArrayList.class.isAssignableFrom(Object.class));  //false
    System.out.println(Object.class.isAssignableFrom(ArrayList.class));  //true
}
}
