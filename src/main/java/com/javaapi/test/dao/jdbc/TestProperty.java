package com.javaapi.test.dao.jdbc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

public class TestProperty {
	@Test
	public void readProperty() {
		Properties p = new Properties();
		try {
			p.load(new InputStreamReader(TestProperty.class
					.getResourceAsStream("/test.properties"), Charset
					.forName("utf-8")));
			Iterator<Entry<Object, Object>> it = p.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Object, Object> entry = it.next();
				System.out.println((String) entry.getKey() + "==>"
						+ (String) entry.getValue());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
