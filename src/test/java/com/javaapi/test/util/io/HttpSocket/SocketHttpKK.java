package com.javaapi.test.util.io.HttpSocket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * http://blog.csdn.net/jia20003/article/details/17104791
 * http://royaki.iteye.com/blog/685317
 */
public class SocketHttpKK {

	private static final String	host	= " 180.97.33.108";
	private static final int			port	= 80;
	private String				path	= "/";

	@Test
	public void get() {
		// SocketAddress dest = new InetSocketAddress(this.host, this.port);
		try {
			Socket socket = new Socket(host, port);
			// socket.connect(dest);
			OutputStream outputStream = socket.getOutputStream();
			BufferedWriter bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(outputStream));
			bufferedWriter.write("GET " + path + " HTTP/1.1\r\n");
			bufferedWriter.write("Host: www.baidu.com\r\n");
			bufferedWriter.write("\r\n");
			bufferedWriter.flush();
			BufferedInputStream streamReader = new BufferedInputStream(
					socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
					streamReader, "utf-8"));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedWriter.close();
			bufferedReader.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * http://www.blogjava.net/myfly/archive/2009/09/10/230875.html
	 */
	@Test
	public void testString半角() {
		String shuzi = "5";
		String shuzi2 = "413";
		System.out.println(shuzi.getBytes().length);
		System.out.println(shuzi2.getBytes().length);
		String a = "a";
		String ab = "ab";
		System.out.println(a.getBytes().length);
		System.out.println(ab.getBytes().length);
		String ni = "你";
		String hao = "好";
		System.out.println(ni.getBytes().length);
		System.out.println(hao.getBytes().length);
	}

	@Test
	public void testString全角() {
		String shuzi = "５";
		String shuzi2 = "４１４";
		System.out.println(shuzi.getBytes().length);
		System.out.println(shuzi2.getBytes().length);
		String a = "ａ";
		String ab = "ａｂ";
		System.out.println(a.getBytes().length);
		System.out.println(ab.getBytes().length);
		String ni = "你";
		String hao = "好";
		System.out.println(ni.getBytes().length);
		System.out.println(hao.getBytes().length);
	}
}
