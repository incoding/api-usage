package com.javaapi.test.appframework.readWriteSeparate;

import com.javaapi.test.appframework.readWriteSeparate.entity.User;
import com.javaapi.test.appframework.readWriteSeparate.manager.UserMng;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("application.xml")
@Transactional
@Rollback(value = false)
public class ClientUser {

    @Autowired
    UserMng userMng;

    @Test
    public void testSelect() {
        User user1 = new User();
        user1.setUsername("nihao");
        User user = userMng.selectOne(user1);
        System.out.println("user = " + user);
    }

    @Test
    public void testSave() {
        User user1 = new User();
        user1.setUsername("nihao");
        user1.setPassword("nihao");
        userMng.save(user1);
    }
}
