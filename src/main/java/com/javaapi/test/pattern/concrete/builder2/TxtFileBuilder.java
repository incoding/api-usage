package com.javaapi.test.pattern.concrete.builder2;

public class TxtFileBuilder implements FileBuilder {

	private MyFile file = new MyFile();;

	public void buildHead() {

		file.setHead("this it the txt file head");

	}

	public void buildContent() {

		file.setContent("this it the txt file content");

	}

	public void buildEnd() {

		file.setEnd("this it the txt file end");

	}

	public MyFile getResult() {

		return file;

	}

}
