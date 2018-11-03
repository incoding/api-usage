package com.javaapi.test.util.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

/**
 * �����̳�����,URL,UrlConnection,URLDecoder,URLEncoder,InetAddress,
 * 
 */
public class TestNet {
	/**
	 * ������ͨ������ post
	 * 
	 * @throws IOException
	 */
	@Test
	public void post() throws IOException {
		String path = "http://www.baidu.com";
		// �½�һ��URL����
		URL url = new URL(path);
		// ��һ��HttpURLConnection����
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		// �������ӳ�ʱʱ��
		urlConn.setConnectTimeout(5 * 1000);
		urlConn.setDoOutput(true);
		// Post������ʹ�û���
		urlConn.setUseCaches(false);
		// ����ΪPost����
		urlConn.setRequestMethod("POST");
		urlConn.setInstanceFollowRedirects(true);
		// ��������Content-Type
		urlConn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencode");
		// ��ʼ����
		// urlConn.connect();
		// �ж������Ƿ�ɹ�
		if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			// ��ȡ���ص����
			BufferedReader br = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream(), "GBK"));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				System.out.println(temp + System.lineSeparator());
			}
		} else {
			System.out.println("ʧ��");
		}
		// �ر�����
		urlConn.disconnect();
	}

	/**
	 * ������ͨ������ get
	 * 
	 * @throws IOException
	 */
	@Test
	public void get() throws IOException {
		String path = "http://www.baidu.com";
		URL url = new URL(path);
		url.getProtocol();
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		urlConn.setRequestMethod("GET");
		urlConn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencode");
		urlConn.connect();
		if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream(), "GBK"));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				System.out.println(temp + System.lineSeparator());
			}
		} else {
			System.out.println("ʧ��");
		}
		urlConn.disconnect();
	}
	@Test
	public void testName() throws Exception {
		URL url = new URL("file://home/kk/git/service/src/main/webapp/pages/");
		System.out.println(url);
	}
}
