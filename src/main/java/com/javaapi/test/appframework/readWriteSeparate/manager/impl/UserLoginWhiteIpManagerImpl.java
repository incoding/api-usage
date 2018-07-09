package com.javaapi.test.appframework.readWriteSeparate.manager.impl;

import com.javaapi.test.appframework.readWriteSeparate.annotation.Datasource;
import com.javaapi.test.appframework.readWriteSeparate.dao.UserLoginWhiteIpMapper;
import com.javaapi.test.appframework.readWriteSeparate.entity.UserLoginWhiteIp;
import com.javaapi.test.appframework.readWriteSeparate.manager.UserLoginWhiteIpMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserLoginWhiteIpManagerImpl implements UserLoginWhiteIpMng {

    @Autowired
    private UserLoginWhiteIpMapper userDao;


    @Override
    public void save(UserLoginWhiteIp user) {
        userDao.save(user);
    }

    @Override
    @Datasource(value = "slave")
    public void saveWithAnnotation(UserLoginWhiteIp user) {
        userDao.save(user);
    }

    @Override
    public UserLoginWhiteIp selectOne(UserLoginWhiteIp user) {
        return userDao.selectFirst(user);
    }
    @Override
    @Datasource(value = "master")
    public UserLoginWhiteIp selectOneWithAnnotation(UserLoginWhiteIp user) {
        return userDao.selectFirst(user);
    }
}
