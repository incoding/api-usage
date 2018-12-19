package com.javaapi.test.test.property;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class JcUtil {

	public static void main(String[] args) {
		String var = "需要检查得例子";

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(
					JcUtil.class.getResourceAsStream("sensitivewords1.txt"),
					Charset.forName("utf-8")));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				System.out.println(temp);
				if (var.indexOf(temp) != -1) {
					System.out.println("=======>" + temp);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}