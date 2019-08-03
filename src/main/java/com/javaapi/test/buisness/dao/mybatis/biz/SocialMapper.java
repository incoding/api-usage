package com.javaapi.test.buisness.dao.mybatis.biz;

import java.util.List;

import com.javaapi.test.buisness.dao.mybatis.Social;

public interface SocialMapper {

	/**
	 * @test
	 */
    Social getTop1User();

    List<Social> getUserList();

    Integer setUser(Social user);
}
