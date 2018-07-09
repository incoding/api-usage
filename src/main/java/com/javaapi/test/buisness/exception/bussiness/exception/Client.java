package com.javaapi.test.buisness.exception.bussiness.exception;

import com.javaapi.test.buisness.exception.bussiness.exception.exception.BusinessException;
import com.javaapi.test.buisness.exception.bussiness.exception.exception.ErrorCode;
import org.junit.Test;

/**
 * Created by user on 16/2/28.
 */
public class Client {


    @Test
    public void test(){
        try {
            throw new BusinessException(ErrorCode.commonError);
        } catch (BusinessException e) {
            ErrorCode error = e.getError();
            System.out.println("error = " + error.getMsg());
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        System.out.println("done");

    }
}
