package com.javaapi.test.buisness.exception.bussiness.exception_v2;

import com.google.common.base.Joiner;
import com.javaapi.test.buisness.exception.bussiness.exception_v2.exception.BusinessException;
import com.javaapi.test.buisness.exception.bussiness.exception_v2.exception.ErrorCode;
import org.junit.Test;

/**
 * Created by user on 18/2/7.
 */
public class Client {
    @Test
    public void test() {
        try {
            throw new BusinessException(ErrorCode.MEMBER_ERROR);
        } catch (BusinessException e) {
            e.printStackTrace();
            String join = Joiner.on("___").join(e.getKey(), e.getMsg());
            System.out.println("join = " + join);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        System.out.println("done");
    }

    @Test
    public void test2() {
        throw new BusinessException("common.error","普通异常");
    }
    @Test
    public void test3(){
        for (int i = 1; i < 2; i++) {
            System.out.println("i = " + i);

        }

    }
}
