package com.javaapi.test.pattern.concrete.builder;

public interface PersonBuilder {

	void buildHead();

	void buildBody();

	void buildFoot();

	Person buildPerson();
}
