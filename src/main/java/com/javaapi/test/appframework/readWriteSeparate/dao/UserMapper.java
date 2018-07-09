package com.javaapi.test.appframework.readWriteSeparate.dao;

import com.javaapi.test.appframework.readWriteSeparate.entity.User;

@MyBatisRepository
public interface UserMapper {

    public User selectOne(User user);

    void save(User user);
}