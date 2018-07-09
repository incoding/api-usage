package com.javaapi.test.dao.jdbc.datasource.springdatasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javaapi.test.dao.jdbc.JdbcExe;
import com.javaapi.test.dao.jdbc.JdbcPrepare;

/**
 * http://blog.csdn.net/kunkun378263/article/details/8506355
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class TestSpringDataSource {
	@Autowired
	DataSource datasource;
	
	@Test
	public void testSpringDataSource(){
		Connection con;
	try {
		con = datasource.getConnection();
		String sql = "SELECT * FROM csc_sns_dev.tbl_b";
		PreparedStatement ps=JdbcPrepare.getPrepareStatement(con, sql);
		ResultSet rs=JdbcExe.executeQuery(ps);
		while (rs.next()) {
			Integer id=rs.getInt("Id");
			String val=rs.getString("val");
			System.out.println("id==>"+id+"      "+"val==>"+val);
		}
		} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
