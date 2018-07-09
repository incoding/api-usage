package com.javaapi.test.appframework.readWriteSeparate;

import com.javaapi.test.appframework.readWriteSeparate.entity.UserLoginWhiteIp;
import com.javaapi.test.appframework.readWriteSeparate.manager.UserLoginWhiteIpMng;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("application.xml")
public class Client {

    @Autowired
    UserLoginWhiteIpMng userLoginWhiteIpMng;

    @Test
    public void testSelect() {
        UserLoginWhiteIp userLoginWhiteIp = userLoginWhiteIpMng.selectOne(new UserLoginWhiteIp());
        System.out.println("userLoginWhiteIp = " + userLoginWhiteIp);
    }
    @Test
    public void testSelectWithAnnotation() {
        UserLoginWhiteIp userLoginWhiteIp = userLoginWhiteIpMng.selectOneWithAnnotation(new UserLoginWhiteIp());
        System.out.println("userLoginWhiteIp = " + userLoginWhiteIp);
    }

    @Test
    @Rollback(value = false)
    public void testSave() {
        UserLoginWhiteIp user = new UserLoginWhiteIp();
        user.setIp("127.0.0.12");
        userLoginWhiteIpMng.save(user);
    }

    @Test
    @Rollback(value = false)
    public void testSaveWithAnnotation() {
        UserLoginWhiteIp user = new UserLoginWhiteIp();
        user.setIp("127.0.0.12");
        userLoginWhiteIpMng.saveWithAnnotation(user);
    }



}
