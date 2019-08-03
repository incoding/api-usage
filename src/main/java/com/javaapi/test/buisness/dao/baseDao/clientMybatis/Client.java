package com.javaapi.test.buisness.dao.baseDao.clientMybatis;

import com.javaapi.test.buisness.dao.baseDao.domain.User;
import com.javaapi.test.buisness.dao.baseDao.repositoryMybatis.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Transactional
public class Client {

    @Autowired
    private UserDao userDao;

    @Test
    public void testName() throws Exception {
        User byId = userDao.findById(5);
        System.out.println("byId = " + byId);
    }
}