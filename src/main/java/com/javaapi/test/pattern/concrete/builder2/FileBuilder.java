package com.javaapi.test.pattern.concrete.builder2;

public interface FileBuilder {

	void buildHead();

	void buildContent();

	void buildEnd();

	MyFile getResult();

}
