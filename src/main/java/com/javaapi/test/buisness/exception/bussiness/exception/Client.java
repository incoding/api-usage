package com.javaapi.test.buisness.exception.bussiness.exception;

import com.javaapi.test.buisness.exception.bussiness.exception.exception.BusinessException;
import com.javaapi.test.buisness.exception.bussiness.exception.exception.ErrorCode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 16/2/28.
 */
public class Client {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @Test
    public void testExt(){
        try {
            throw new BusinessException(ErrorCode.commonError,"nihao");
        } catch (BusinessException e) {
            ErrorCode error = e.getError();
            System.out.println("ext = " + e.getExt());
            System.out.println("error = " + error.getMsg());
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        System.out.println("done");
    }

    @Test
    public void testException() throws Exception {
        try {
            throw new BusinessException(ErrorCode.commonError,"nihao");
        } catch (BusinessException e) {
            logger.error("BannerRedpacketController acquireRedpacket exception:",e);
        } catch (Exception e) {
//            System.out.println("e = " + e);
        }

    }
}
