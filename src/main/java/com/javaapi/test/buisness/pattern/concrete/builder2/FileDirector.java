package com.javaapi.test.buisness.pattern.concrete.builder2;

public class FileDirector {

	private FileBuilder filebuilder;

	public FileDirector(FileBuilder filebuilder) {

		this.filebuilder = filebuilder;

	}

	public MyFile construct() {

		filebuilder.buildHead();

		filebuilder.buildContent();

		filebuilder.buildEnd();

		return filebuilder.getResult();

	}

}
