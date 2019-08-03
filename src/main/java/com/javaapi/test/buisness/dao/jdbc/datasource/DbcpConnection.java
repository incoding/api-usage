package com.javaapi.test.buisness.dao.jdbc.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DbcpConnection {
private static DataSource dataSource;
private static Connection con;

public DbcpConnection() {
}

public static Connection getConnection() {
    if (dataSource == null) {
        initDataSource();
    }
    try {
        con = dataSource.getConnection();
        print();

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return con;

}

public static void initDataSource() {
    FileInputStream is = null;
    Properties p = new Properties();
    String driverClassName = null;
    String url = null;
    String username = null;
    String password = null;
    int initialSize = 0;
    int minIdle = 0;
    int maxIdle = 0;
    int maxWait = 0;
    int maxActive = 0;
    try {
        String path = DbcpConnection.class.getResource("").getPath();
        is = new FileInputStream(path + "dbcp.properties");
        p.load(is);
        driverClassName = p.getProperty("dbcp.driverClassName");
        url = p.getProperty("dbcp.url");
        username = p.getProperty("dbcp.username");
        password = p.getProperty("dbcp.password");

        initialSize = Integer.parseInt(p.getProperty("dbcp.initialSize"));
        minIdle = Integer.parseInt(p.getProperty("dbcp.minIdle"));
        maxIdle = Integer.parseInt(p.getProperty("dbcp.maxIdle"));
        maxWait = Integer.parseInt(p.getProperty("dbcp.maxWait"));
        maxActive = Integer.parseInt(p.getProperty("dbcp.maxActive"));
    } catch (NumberFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch(Exception e){
    	e.printStackTrace();
    }finally {
        try {
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    BasicDataSource ds = new BasicDataSource();
    ds.setUrl(url);
    ds.setDriverClassName(driverClassName);
    ds.setUsername(username);
    ds.setPassword(password);

    ds.setInitialSize(initialSize); // 初始的连接数；
    ds.setMaxActive(maxActive);
    ds.setMinIdle(minIdle);
    ds.setMaxIdle(maxIdle);
    ds.setMaxWait(maxWait);
    ds.setRemoveAbandoned(true);
    ds.setRemoveAbandonedTimeout(2000);
    dataSource = ds;

}

/* 用于测试连接状态的方法 */
public static void print() {
    BasicDataSource ds = (BasicDataSource) dataSource;
    System.out.println(ds.getInitialSize());
    System.out.println(ds.getNumActive());
    System.out.println(ds.getNumIdle());
    System.out.println(ds.getDefaultAutoCommit());
}

public static void main(String[] args) {

    Connection con;
    try {
        con = DbcpConnection.getConnection();
        print();
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery("select * from csc_sns_dev.tbl_b");
        System.out.println("----------------");
        while (result.next()) {
            String gmtModified = result.getString("val");
            Integer value = result.getInt("id");
            System.out.println("gmt_modified="+gmtModified+"  value="+value);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}   }