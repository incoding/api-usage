package com.javaapi.test.test.javafeature.testFinally;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

/**
 * Created by user on 2019/5/17
 */
public class Client3CatchThrow {

    /**
     * 测试 catch throw finally 组合 case1  . try 发生异常
     * finally 可以获取到catch阶段处理的变量值
     */
    @Test
    public void testCatchThrowFinallyCase1() {
        String response = "param";
        invokeCatchThrowFinally(response);
    }

    /**
     * 测试 catch throw finally 组合 case2 .  try 业务正常
     */
    @Test
    public void testCatchThrowFinallyCase2() {
        String response = "param";
        invokeCatchThrowFinallyCase2(response);
    }

    /**
     * 测试 catch throw finally throw 组合 case
     */
    @Test
    public void testCatchThrowFinallyThrow() {
        String response = "param";
        invokeCatchThrowFinallyThrow(response);
    }


    private void invokeCatchThrowFinally(String response) {
        String responseStr = null;
        try {
            throw new IllegalStateException("wrong status");
        } catch (IllegalStateException e) {
            responseStr = ExceptionUtils.getStackTrace(e);
            throw e;
        } finally {
            if (responseStr == null) {
                responseStr = response;
            }
            log(responseStr);
        }
    }

    private void invokeCatchThrowFinallyCase2(String response) {
        String responseStr = null;
        try {
            response = "new Response";
        } catch (IllegalStateException e) {
            responseStr = ExceptionUtils.getStackTrace(e);
            throw e;
        } finally {
            if (responseStr == null) {
                responseStr = response;
            }
            log(responseStr);
        }
    }

    /**
     * 看一下 finally有异常,是返回哪个异常?
     * 返回的是 finally异常里发生的最新异常
     *
     * @param response
     */
    private void invokeCatchThrowFinallyThrow(String response) {
        String responseStr = null;
        try {
            throw new IllegalStateException("异常");
        } catch (IllegalStateException e) {
            responseStr = ExceptionUtils.getStackTrace(e);
            throw e;
        } finally {
            if (responseStr == null) {
                responseStr = response;
            }
            logException(responseStr);
        }
    }


    private void log(String response) {
        System.out.println("response = " + response);
    }

    /**
     * 模拟写日志发生异常
     *
     * @param response
     */
    private void logException(String response) {
        if (true) {
            throw new RuntimeException("log exception");
        }
        System.out.println("response = " + response);
    }
}
