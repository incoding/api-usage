package com.javaapi.test.test.reflect.genericBaseDao;

import com.javaapi.test.test.reflect.genericBaseDao.dao.UserDao;
import org.junit.Test;


public class Client {
    @Test
    public void test() {
        UserDao userDao = new UserDao();
        System.out.println(userDao.getClazz());
    }
}
