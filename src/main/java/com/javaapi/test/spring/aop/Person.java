package com.javaapi.test.spring.aop;

import java.io.FileNotFoundException;

public interface Person {  
    public void info();  
    public void show(String message) throws FileNotFoundException;  
}  