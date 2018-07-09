package com.javaapi.test.appframework.readWriteSeparate.manager;


import com.javaapi.test.appframework.readWriteSeparate.annotation.Datasource;
import com.javaapi.test.appframework.readWriteSeparate.entity.UserLoginWhiteIp;

/**
 */
public interface UserLoginWhiteIpMng {

    public void save(UserLoginWhiteIp user);

    @Datasource
    void saveWithAnnotation(UserLoginWhiteIp user);

    UserLoginWhiteIp selectOne(UserLoginWhiteIp user);

    @Datasource(value = "slave")
    UserLoginWhiteIp selectOneWithAnnotation(UserLoginWhiteIp user);
}
