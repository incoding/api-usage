package com.javaapi.test.buisness.dao.jdbc.jdbc.hsqldb;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 *http://maimode.iteye.com/blog/1415644 内存运行方式不错
 * http://www.cnblogs.com/kenkofox/archive/2010/12/01/1893782.html 这个做了解
 */
public class TestHsqlDb {
    @Before
    public void setUp(){
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        try {
            //加载HSQLDB的JDBC驱动
            //在内存中建立数据库memdb,用户名为sa,密码为空
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:memdb","username","password");
            System.out.println("connect to memdb OK");

            Statement stat = conn.createStatement();
            //新建数据表
            stat.executeUpdate("create table person(NAME VARCHAR(20), AGE INTEGER)");
            System.out.println("create TABLE:person OK");

            //插入数据
            stat.executeUpdate("INSERT INTO person VALUES('张三丰',22)");
            stat.executeUpdate("INSERT INTO person VALUES('amos','25')");
            System.out.println("insert data into TABLE:person OK!");

            conn.close();

//          stat.execute("SHUTDOWN");
//          System.out.println("SHUTDOWN");

            Connection conn2 = DriverManager.getConnection("jdbc:hsqldb:mem:memdb","username","password");

            //查询数据
            PreparedStatement pstmt = conn2.prepareStatement("SELECT * FROM person");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                String s = null;
                s = rs.getString(1) + "," + rs.getString(2);
                System.out.println(s);
            }
            System.out.println("select data OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
