package com.javaapi.test.buisness.exception.exceptionusage.commonexception;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 常用异常
 *
 */
public class ClientException {
	@Test
	public void SQLException(){
		try {
			throw new SQLException("数据库相关异常");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void IOException(){
//		try{
			try {
				throw new IOException("文件相关异常");
			} catch (IOException e) {
			throw new RuntimeException("文件相关异常", e.getCause());
			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	
	}

}
