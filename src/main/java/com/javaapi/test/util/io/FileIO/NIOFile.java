package com.javaapi.test.util.io.FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import jodd.util.MathUtil;

import org.junit.Test;

/**
 * select 只能对套接字channel可以使用,filechannel不可以用
 * 
 * @author hncw
 * 
 */
public class NIOFile {
	private static final String S = File.separator;
	// 编译之后得类路径
	private static final String txtPath = CommonFileIO.class.getResource("")
			.getPath() + "TestCmd.txt";;
	// 明显是源码路径
	private static final String tempString = "D:" + S + "workspace2012-11-12"
			+ S + "JavaApiSample" + S + "src" + S + "com" + S + "javaapi" + S
			+ "test" + S + "testRuntime" + S + "TestCmd.txt";
	private static final String STRING = txtPath;
	private static final String imagePath = "C:" + S + "Users" + S + "hncw" + S
			+ "Desktop" + S;

	private static final String IMAGEPATH = imagePath;

	private static final int random = MathUtil.randomInt(0, 1000);

	/**
	 * 面向块
	 */
	@Test
	public void testReadWrite() {
		FileInputStream is;
		FileOutputStream os;
		ByteBuffer buffer;
		int r = 0;
		try {
			is = new FileInputStream(new File(imagePath + "136.jpg"));
			os = new FileOutputStream(new File(imagePath + random + ".jpg"));
			FileChannel fsi = is.getChannel();
			FileChannel fso = os.getChannel();
			buffer = ByteBuffer.allocate(1024);
			while (true) {
				buffer.clear();
				if ((r = fsi.read(buffer)) == -1) {
					break;
				}
				buffer.flip();
				fso.write(buffer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * NIO解决中文乱码
	 * 
	 * @throws
	 */
	@Test
	public void nioRead() throws IOException {
		Charset cs = Charset.forName("GBK");
		FileInputStream in = new FileInputStream(imagePath + "hello.txt");
		FileChannel channel = in.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		byte[] arr = buffer.array();
		System.out.println(new String(arr, cs));
		channel.close();
		in.close();
	}

	@Test
	public void nioReadChinese() {
		Charset charset = Charset.forName("GBK");// Java.nio.charset.Charset处理了字符转换问题。它通过构造CharsetEncoder和CharsetDecoder将字符序列转换成字节和逆转换。
		CharsetDecoder decoder = charset.newDecoder();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(imagePath + "hello.txt");
			FileChannel fileChannel = fis.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			CharBuffer charBuffer = CharBuffer.allocate(1024);
			int bytes = fileChannel.read(byteBuffer);
			while (bytes > -1) {
				byteBuffer.flip();
				decoder.decode(byteBuffer, charBuffer, false);
				charBuffer.flip();
				System.out.println(charBuffer);
				// charBuffer.clear();
				// byteBuffer.clear();
				// bytes = fileChannel.read(byteBuffer);
			}
			if (fis != null) {
				fis.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
