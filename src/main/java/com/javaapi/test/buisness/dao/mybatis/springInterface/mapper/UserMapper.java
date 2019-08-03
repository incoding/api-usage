package com.javaapi.test.buisness.dao.mybatis.springInterface.mapper;

import com.javaapi.test.buisness.dao.mybatis.User;



public interface UserMapper {
	User getUser();

	int insertUserTypeHandler(User user);

	User getOneUser(User user);
}