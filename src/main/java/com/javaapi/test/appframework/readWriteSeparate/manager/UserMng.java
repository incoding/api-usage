package com.javaapi.test.appframework.readWriteSeparate.manager;


import com.javaapi.test.appframework.readWriteSeparate.entity.User;

/**
 */
public interface UserMng {

    public void save(User user);

    User selectOne(User user);
}
