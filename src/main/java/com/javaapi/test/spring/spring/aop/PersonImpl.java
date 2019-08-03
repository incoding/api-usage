package com.javaapi.test.spring.spring.aop;

import java.io.FileNotFoundException;


public class PersonImpl implements Person {  
    private String name;  
    private int age;  
      
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public void info() {  
        System.out.println("\t我叫" + name + ",今年" + age + "岁。");  
    }  
  
    public void show(String message) throws FileNotFoundException { 
    	System.out.println(message);  
//    	try{
    		throw new FileNotFoundException("文件没找到!");
//    	}catch(Exception e){
//    		System.out.println(e.getMessage());
//    	}
    	
    }  
}  