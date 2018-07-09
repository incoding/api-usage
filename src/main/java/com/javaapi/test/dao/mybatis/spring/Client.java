package com.javaapi.test.dao.mybatis.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.javaapi.test.dao.domain.page2.DataPage;
import com.javaapi.test.dao.mybatis.Social;
import com.javaapi.test.dao.mybatis.UserInfo;
import com.javaapi.test.dao.mybatis.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Transactional
public class Client {

	@Autowired
	SqlSessionTemplate	sqlSessionTemplate;

	@Test
	public void selectOne() {
		String selectOne = "testNamespace.countUser";
		Integer a = sqlSessionTemplate.selectOne(selectOne);
		System.out.println(a);
	}

	@Test
	public void selectOneObjectResultType() {
		String selectOne = "testNamespace.getTop1User";
		Social a = sqlSessionTemplate.selectOne(selectOne);
		System.out.println(a);

		List<Social> list = sqlSessionTemplate.selectList(selectOne);
		System.out.println(list);
	}

	@Test
	public void selectOneObjectResultMap() {
		String selectOne = "testNamespace.getTop1UserResultMap";
		Social a = sqlSessionTemplate.selectOne(selectOne);
		System.out.println(a);
	}

	@Test
	public void selectListObject() {
		String selectOne = "testNamespace.getTop1UserResultMap";
		List<Social> a = sqlSessionTemplate.selectList(selectOne);
		System.out.println(a);
	}
	@Test
	public void selectPageObject() {
		String selectOne = "testNamespace.getPageUser";
		Map<String,Object> map = new HashMap<>();
		DataPage<Social> page = new DataPage<>();
		page.setPageNo(1);
		page.setPageSize(10);
		page.setOrder(DataPage.DESC);
		page.setOrderBy("phone");
		map.put("page", page);
		map.put("start", page.getFirst());
		map.put("end", page.getEndIndex());
		List<Social> a = sqlSessionTemplate.selectList(selectOne,map);
		System.out.println(a);
	}

	@Test
	public void insertTypeHandler() {
		String insertOne = "testNamespace.insertUserTypeHandler";
		User user = new User();
		user.setName("kk");
		UserInfo testTypeHandler = new UserInfo();
		testTypeHandler.setPhone("12312312312");
		testTypeHandler.setEmail("163.com");
		user.setTestTypeHandler(testTypeHandler);
		int a = sqlSessionTemplate.insert(insertOne, user);
		System.out.println(a);
		System.out.println(user.getId());
		// String getOneUser = "testNamespace.getOneUser";
		// sqlSessionTemplate.selectOne(getOneUser, user);
	}

	@Test
	public void selectTypeHandler() {
		User user = new User();
		user.setId(Integer.parseInt("6"));
		String getOneUser = "testNamespace.getOneUser";
		User myUser = sqlSessionTemplate.selectOne(getOneUser, user);
		System.out.println(myUser.getTestTypeHandler().getPhone());
		System.out.println(myUser.getTestTypeHandler().getEmail());
	}
}
