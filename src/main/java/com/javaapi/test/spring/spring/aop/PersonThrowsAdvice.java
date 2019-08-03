package com.javaapi.test.spring.spring.aop;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 *  当连接点抛出异常时，异常通知被调用。实现异常通知需要实现org.springframework.aop.ThrowsAdvice接口，该接口不包含任何方法，但在实现该接口时必须实现如下形式的方法：
                 afterThrowing([Method], [args], [target], Throwable subclass)
          可以实现一个或多个这样的方法。在这些方法中，只有第四个参数是必需的，前三个参数可选。
 *@see http://chenjumin.iteye.com/blog/364948
 */
public class PersonThrowsAdvice implements ThrowsAdvice {  
    public void afterThrowing(FileNotFoundException ex){  
        System.out.println("ThrowsAdvice >> FileNotFoundException：" + ex.toString());  
    }  
  
    public void afterThrowing(Object[] args, Exception ex){  
        System.out.println("ThrowsAdvice >> Exception：" + ex.getMessage());  
    }  
  
    public void afterThrowing(Method method, Object[] args, Object target, Throwable ex){  
        System.out.println("ThrowsAdvice >> Throwable：" + ex.getMessage());  
    }  
}  