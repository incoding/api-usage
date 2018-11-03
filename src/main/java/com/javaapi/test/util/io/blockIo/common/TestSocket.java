package com.javaapi.test.util.io.blockIo.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TestSocket {
	/**
	 * simple test,common blocking io
	 */
	@Test
	public void Server() {
		try {
			ServerSocket ss = new ServerSocket(10002);
			Socket socket = ss.accept();
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String tmp;
			while ((tmp = br.readLine()) != null) {
				System.out.println("服务器接受到信息:" + tmp + System.lineSeparator());
			}
			br.close();
			is.close();
			socket.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
