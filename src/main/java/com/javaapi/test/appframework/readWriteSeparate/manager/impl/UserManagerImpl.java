package com.javaapi.test.appframework.readWriteSeparate.manager.impl;

import com.javaapi.test.appframework.readWriteSeparate.dao.UserMapper;
import com.javaapi.test.appframework.readWriteSeparate.manager.UserMng;
import com.javaapi.test.appframework.readWriteSeparate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManagerImpl implements UserMng {

    @Autowired
    private UserMapper userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User selectOne(User user) {
        return userDao.selectOne(user);
    }
}
