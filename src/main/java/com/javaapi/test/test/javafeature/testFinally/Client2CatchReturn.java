package com.javaapi.test.test.javafeature.testFinally;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

/**
 * Created by user on 2019/5/17
 */
public class Client2CatchReturn {


    /**
     * 测试 catch return finally 组合
     * 返回的是字符串
     * 返回的是catch的结果
     */
    @Test
    public void testCatchReturnFinally() {
        String response = null;
        String s = invokeCatchReturn(response);
        System.out.println("s = " + s);
    }

    /**
     * 测试 catch return finally return组合
     * 返回的是字符串
     * 返回的是finally的结果
     */
    @Test
    public void testCatchReturnFinallyReturn() {
        String response = null;
        String s = invokeCatchReturnFinallyReturn(response);
        System.out.println("s = " + s);
    }


    private String invokeCatchReturn(String response) {
        try {
            throw new IllegalStateException("wrong status");
        } catch (IllegalStateException e) {
            log(ExceptionUtils.getStackTrace(e));
            return "catch";
        } finally {
            log(response);
        }
    }

    private String invokeCatchReturnFinallyReturn(String response) {
        try {
            throw new IllegalStateException("wrong status");
        } catch (IllegalStateException e) {
            log(ExceptionUtils.getStackTrace(e));
            return "catch";
        } finally {
            log(response);
            return "finally";
        }
    }

    private void log(String response) {
        System.out.println("response = " + response);
    }
}
