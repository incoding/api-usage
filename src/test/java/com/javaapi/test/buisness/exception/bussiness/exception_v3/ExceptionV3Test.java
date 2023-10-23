package com.javaapi.test.buisness.exception.bussiness.exception_v3;


import org.junit.Test;

public class ExceptionV3Test {

    @Test
    public void test(){
        ResponseEnum.BAD_LICENCE_TYPE.assertNotNull(null);
    }

}