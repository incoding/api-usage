package com.javaapi.test.buisness.dao.mybatis.thirdpart.tk;

import com.javaapi.test.buisness.dao.mybatis.thirdpart.dao.UserDao;
import com.javaapi.test.buisness.dao.mybatis.thirdpart.domain.User;
import com.javaapi.test.buisness.dao.mybatis.thirdpart.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by user on 16/1/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
    @Autowired
    private UserDao userDao;

    @Autowired
    private DemoService demoService;

    @Test
    public void testSelectAll() throws Exception {
        List<User> users = userDao.selectAll();
        System.out.println("users = " + users);

    }

    @Test
    public void testService() {
        User byId = demoService.findById(5);
        System.out.println("byId = " + byId);
    }
}