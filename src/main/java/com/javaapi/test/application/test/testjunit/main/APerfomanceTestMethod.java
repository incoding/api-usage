package com.javaapi.test.application.test.testjunit.main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;

public class APerfomanceTestMethod {
    
    public static void main(String[] args) {
         new Thread() {
             public void run() {
                 new JUnitCore().run(Request.method(ATest.class, "测试功能1"));
            }
         }.start();
    }
 }