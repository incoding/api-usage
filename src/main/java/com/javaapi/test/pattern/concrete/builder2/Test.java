package com.javaapi.test.pattern.concrete.builder2;
public class Test {
	public static void main(String[] args) {
		FileBuilder builder = new XmlFileBuilder();

		FileDirector director = new FileDirector(builder);

		MyFile file = director.construct();

		// 省略了使用对象的代码
	}

}