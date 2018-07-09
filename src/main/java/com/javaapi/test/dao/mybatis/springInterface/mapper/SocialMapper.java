package com.javaapi.test.dao.mybatis.springInterface.mapper;

import java.util.List;

import com.javaapi.test.dao.mybatis.Social;

public interface SocialMapper {
	List<Social> getUserList();

	Social getTop1User();

	Social getTop1UserResultMap();

	int setUser(Social user);

	int countUser();
}