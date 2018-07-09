package com.javaapi.test.application.test.testmockito.tutorials.basedemo2;

public class UserServiceImpl implements UserService {

	@Override
	public User findUserByUserName(String string) {
		return null;
	}
	@Override
	public boolean hasMatchUser(String string, String string2) {
		System.err.println("hasMatchUser method");
		return false;
	}

	@Override
	public void registerUser(User u) {

	}

}
