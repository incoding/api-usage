package com.javaapi.test.dao.mybatis.springInterface.mapper;

import com.javaapi.test.dao.mybatis.User;



public interface UserMapper {
	User getUser();

	int insertUserTypeHandler(User user);

	User getOneUser(User user);
}