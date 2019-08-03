package com.javaapi.test.buisness.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TestJdbc {
    private static final String url      = "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8";
    private static final String username = "root";
    private static final String password = "root";



    /**
     * java原生的PrepareStatement 只能按索引传递参数 
     */
    @Test
    public void commonBatch() {
        String url = "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
        String sql = "SELECT * FROM tbl_b;INSERT INTO  tbl_b (id,val) values(?,?);";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = JdbcPrepare.getPrepareStatement(con, sql);
        try {
            ps.setString(1, "1");
            ps.setString(2, "d");
            ps.addBatch();
            System.out.println("这里是断点");
            ps.setString(1, "2");
            ps.setString(2, "d");
            ps.addBatch();
            System.out.println("这里是断点");
            ps.setString(1, "3");
            ps.setString(2, "d");
            ps.addBatch();
            System.out.println("这里是断点");
            int[] a = ps.executeBatch();
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcAfter.commit(con);
    }
}
