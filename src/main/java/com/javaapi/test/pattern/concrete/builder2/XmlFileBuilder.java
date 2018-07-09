package com.javaapi.test.pattern.concrete.builder2;

public class XmlFileBuilder implements FileBuilder {

	private MyFile file = new MyFile();;

	public void buildHead() {

		file.setHead("<!--?xml version=\"1.0\"?--><content>");

	}

	public void buildContent() {

		file.setContent("<node>value</node>");

	}

	public void buildEnd() {

		file.setEnd("</content>");

	}

	public MyFile getResult() {

		return file;

	}

}
