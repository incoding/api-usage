package com.javaapi.test.dao.jpa.springJpa.dao.impl;

import com.javaapi.test.dao.jpa.springJpa.model.User;

/**
 * Created by user on 16/7/16.
 */
public class UserDaoImpl {
    public User myFindAll(String kk, String kkpassword) {
        User user = new User();
        user.setUsername(kk);
        user.setPassword(kkpassword);
        return user;
    }

}
