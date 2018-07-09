package com.javaapi.test.appframework.readWriteSeparate.dao;

import com.javaapi.test.appframework.readWriteSeparate.entity.UserLoginWhiteIp;

@MyBatisRepository
public interface UserLoginWhiteIpMapper {
    public void save(UserLoginWhiteIp user);

    UserLoginWhiteIp selectFirst(UserLoginWhiteIp user);
}