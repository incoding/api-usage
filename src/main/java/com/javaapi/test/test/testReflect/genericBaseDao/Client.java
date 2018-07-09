package com.javaapi.test.test.testReflect.genericBaseDao;

import com.javaapi.test.test.testReflect.genericBaseDao.dao.UserDao;
import org.junit.Test;


public class Client {
    @Test
    public void test() {
        UserDao userDao = new UserDao();
        System.out.println(userDao.getClazz());
    }
}
