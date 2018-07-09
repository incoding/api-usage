package com.javaapi.test.dao.baseDao.impl.mybatisThirdPart2;

import com.javaapi.test.dao.baseDao.impl.mybatisThirdPart2.domain.User;
import com.javaapi.test.dao.baseDao.impl.mybatisThirdPart2.service.UserDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by user on 16/1/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {


    @Autowired
    private UserDaoImpl userDao;


    @Test
    public void testService() {
        User byId = userDao.findById(5);
        System.out.println("byId = " + byId);
    }
}