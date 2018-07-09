package com.javaapi.test.buisness.exception.exceptioncause;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *测试异常cause
 */
public class Client {

    @Test
    public void test(){
        try {
             doSomething();
        } catch (Exception e) {
             System.out.println("异常信息是:"+e.getMessage());
             e.printStackTrace();// 打印出3个异常栈信息
        }
    }
    @Test
    public void testCause(){
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println("异常信息是:"+e.getCause().getMessage());
            e.getCause().printStackTrace();// 打印出2个异常栈信息
        }
    }

    @Test
    public void testCauseCause(){
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println("异常信息是:"+e.getCause().getCause().getMessage());
            e.getCause().getCause().printStackTrace(); // 打印1个异常栈信息
        }
    }

    /**
     *最后一个cause是null
     */
    @Test
    public void testCauseCauseCause(){
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println(e.getCause().getCause().getCause());
        }
    }


    private static void doSomething() throws SQLException {
        try {
            try {
                throw new NullPointerException("空指针异常");
            } catch (NullPointerException e) {
                throw new IOException("读取文件异常", e);
            }
        } catch (IOException e) {
            throw new SQLException("获取sql异常", e);
        }
    }
}
