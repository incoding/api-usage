package com.javaapi.test.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.junit.Test;

public class TestIO {

	@Test
	public void printerWriter() {
		PrintWriter pw = new PrintWriter(System.out);
		pw.print("你好");
		pw.flush();
		pw.close();
	}

	@Test
	public void auth() {
		InputStream is;
		FileOutputStream fs;
		try {
			is = new FileInputStream(new File(this.getClass()
					.getResource("NIO.class").getPath()));
			fs = new FileOutputStream(this.getClass().getResource("").getPath()
					+ "NIO2.class");
			byte[] b = new byte[1024];
			while (is.read(b) != -1) {
				fs.write(b);
			}
			is.close();
			fs.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
