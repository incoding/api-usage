package com.javaapi.test.buisness.dao.mybatis;

public class User {

    private Integer id;
    private String  name;
    
	private UserInfo	testTypeHandler;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public UserInfo getTestTypeHandler() {
		return testTypeHandler;
	}

	public void setTestTypeHandler(UserInfo testTypeHandler) {
		this.testTypeHandler = testTypeHandler;
	}

}