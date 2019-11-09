package com.javaapi.test.spring.spring.custom.registry.exceptionhandler;

import com.javaapi.test.buisness.joint.error.BaseError;
import com.javaapi.test.buisness.joint.exception.BusinessException;
import com.javaapi.test.buisness.joint.result.base.BaseResult;
import com.javaapi.test.spring.spring.custom.registry.exceptionhandler.model.ExceptionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by user on 2019/10/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Autowired
    private ExceptionExecutor exceptionExecutor;

    @Test
    public void testGetResult() {
        BusinessException exception = new BusinessException(BaseError.SYS_ERR);
        ExceptionContext context = new ExceptionContext(exception);
        exceptionExecutor.handle(context);
        BaseResult result = context.getResult();
        System.out.println("result = " + result);
    }

    @Test
    public void test() {
        // do nothing
        exceptionExecutor.handle(new ExceptionContext("errorCode", "errorMessage"));

        exceptionExecutor.handle(new ExceptionContext("390", "errorMessage"));

        exceptionExecutor.handle(new BusinessException(BaseError.SYS_ERR));
    }

}
