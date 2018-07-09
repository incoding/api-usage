package com.javaapi.test.pattern.concrete.singleton.serializiable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class WhySerialversionUID {

	@Test
	public void seriable() throws Exception {
		// 这里是把对象序列化到文件
		Person crab = new Person();
		crab.setName("Mr.Crab");
		String path = WhySerialversionUID.class.getResource("").getPath()
				+ "crab_file2";
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
				path));
		oo.writeObject(crab);
		oo.close();
		System.out.println("done");
		// // 这里是把对象序列化到文件，我们先注释掉，一会儿用
		// ObjectInputStream oi = new ObjectInputStream(new FileInputStream(
		// "crab_file"));
		// Person crab_back = (Person) oi.readObject();
		// System.out.println("Hi, My name is " + crab_back.getName());
		// oi.close();

	}

	@Test
	public void deseriable() throws Exception {
		String path = WhySerialversionUID.class.getResource("").getPath()
				+ "crab_file2";
		// 这里是把对象序列化到文件，我们先注释掉，一会儿用
		ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path));
		Person crab_back = (Person) oi.readObject();
		System.out.println("Hi, My name is " + crab_back.getName());
		oi.close();
	}
}