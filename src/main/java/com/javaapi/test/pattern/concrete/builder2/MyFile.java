package com.javaapi.test.pattern.concrete.builder2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFile {

	private String head;

	private String content;

	private String end;

	public void setContent(String content) {

		this.content = content;

	}

	public void setEnd(String end) {

		this.end = end;

	}

	public void setHead(String head) {

		this.head = head;

	}

	public void write(String path) throws IOException {

		File f = new File(path);

		PrintWriter out = new PrintWriter(new FileWriter(f));

		out.println(head);

		out.println(content);

		out.println(end);

		out.close();

	}

}