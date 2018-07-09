package com.javaapi.test.application.test.testjunit.main;

import org.junit.runner.JUnitCore;

public class APerfomanceTest {
    
    public static void main(String[] args) {
         new Thread() {
             public void run() {
                 JUnitCore.runClasses(new Class[] { ATest.class });
            }
         }.start();
    }
 }