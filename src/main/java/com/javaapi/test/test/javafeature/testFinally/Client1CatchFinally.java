package com.javaapi.test.test.javafeature.testFinally;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

/**
 * Created by user on 2019/5/17
 */
public class Client1CatchFinally {
    /**
     * 测试 catch finally 组合执行顺序
     */
    @Test
    public void testCatchFinally() {
        String response = null;
        invokeCatchFinally(response);
    }
    private void invokeCatchFinally(String response) {
        try {
            throw new IllegalStateException("wrong status");
        } catch (IllegalStateException e) {
            log(ExceptionUtils.getStackTrace(e));
        } finally {
            log(response);
        }
    }

    private void log(String response) {
        System.out.println("response = " + response);
    }

}
