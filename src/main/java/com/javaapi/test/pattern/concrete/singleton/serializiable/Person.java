package com.javaapi.test.pattern.concrete.singleton.serializiable;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 最好使用这种形式的serialVersionUID，不要适用值为1的serialVersionUID
	 */
	private static final long serialVersionUID = 6205755953214973548L;

	private String name;

	// // 1先序列化2反序列化之前添加这个成员变量，来测试
	// private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}