package com.javaapi.test.spring.spring.aop.springaop2AutoProxy3AspectJAnnotataion;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundMethod implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // TODO Auto-generated method stub

//        System.out.println("method  name:" + methodInvocation.getMethod().getName());
//
//        System.out.println("method  arguments" + Arrays.toString(methodInvocation.getArguments()));

        System.out.println("Around  method : before ");

        try {

            Object result = methodInvocation.proceed();

            System.out.println("Around method : after ");
            return result;

        } catch (IllegalArgumentException e) {

            System.out.println("Around method : throw  an  exception ");
            throw e;
        }
    }

}
