package com.javaapi.test.application.test.testdbunit.baseSample;

import java.util.ArrayList;
import java.util.List;

/**
 * 暂时不连接数据库得实现
 * 
 */
public class IMemberDao {

	public void insertMember(Member member) {
		// TODO Auto-generated method stub

	}

	public Member findMemberById(int i) {
		Member member = new Member();
		member.setId(i);
		member.setName("sky");
		return member;
	}

	public List<Member> listAllMember() {
		List<Member> list = new ArrayList<>();
		list.add(new Member());
		list.add(new Member());
		list.add(new Member());
		return list;
	}

}
