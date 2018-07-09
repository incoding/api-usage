package com.javaapi.test.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestCase {
    private static final String url      = "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8";
    private static final String username = "root";
    private static final String password = "root";

    /**
     * test executeQuery
     */
    @Test
    public void executeQuery() {
        String sql = "SELECT * FROM tbl_b";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = JdbcPrepare.getPrepareStatement(con, sql);
        ResultSet rs = JdbcExe.executeQuery(ps);
        try {
            while (rs.next()) {
                System.out.println(rs.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcAfter.commit(con);
    }

    @Test
    public void execute() {
        // 设置allowMultiQueries=true; 后可以一个字符串里写多条sql.
        String url = "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
        String sql = "INSERT INTO  tbl_b (id,val) values('7','d');INSERT INTO  tbl_b (id,val) values('8','d');";
        // String sql = "SELECT * FROM tbl_b";
        // String sql = "INSERT INTO  tbl_b (id,val) values('4','d');";
        // String url =
        // "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = JdbcPrepare.getPrepareStatement(con, sql);
        boolean result = JdbcExe.execute(ps);
        System.out.println(result);
        try {
            if (result) {
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    String res = rs.getString("id");
                    System.out.println(res);
                }
            } else {
                int count = ps.getUpdateCount();
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcAfter.commit(con);
    }

    /**
     * test execute twice ,althought we use one connection ,but we use two
     * request.虽然在一个连接当中,但是向mysql发送了2次请求
     */
    @Test
    public void oneConnectionTwoRequest() {
        // String url =
        // "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
        // String sql =
        // "INSERT INTO  tbl_b (id,val) values('1','d');INSERT INTO  tbl_b (id,val) values('2','d');INSERT INTO  tbl_b (id,val) values('3','d');";
        String sql = "INSERT INTO  tbl_b (id,val) values('4','d');";
        String sql2 = "INSERT INTO  tbl_b (id,val) values('5','d');";
        // String sql = "DELETE * FROM tbl_b WHERE id=1";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = JdbcPrepare.getPrepareStatement(con, sql);
        boolean result = JdbcExe.execute(ps);
        System.out.println(result);
        try {
            if (result) {
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    String res = rs.getString("id");
                    System.out.println(res);
                }
            } else {
                int count = ps.getUpdateCount();
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("这里设置断点");
        ps = JdbcPrepare.getPrepareStatement(con, sql2);
        boolean result2 = JdbcExe.execute(ps);
        System.out.println(result);
        try {
            if (result2) {
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    String res = rs.getString("id");
                    System.out.println(res);
                }
            } else {
                int count = ps.getUpdateCount();
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcAfter.commit(con);
    }

    /**
     * 设置allowMultiQueries=true; 后可以一个字符串里写多条sql.获取得结果是字符串中第一条sql得执行结果.
     * 可以在一个请求里执行多条sql.
     */
    @Test
    public void oneConnectionOneRequest() {
        String url = "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
        // String sql =
        // "INSERT INTO  tbl_b (id,val) values('7','d');INSERT INTO  tbl_b (id,val) values('8','d');";
        String sql = "SELECT * FROM  tbl_b;INSERT INTO  tbl_b (id,val) values('9','d');";
        // String sql = "INSERT INTO  tbl_b (id,val) values('4','d');";
        // String url =
        // "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = JdbcPrepare.getPrepareStatement(con, sql);
        boolean result = JdbcExe.execute(ps);
        System.out.println(result);
        try {
            // 获取得结果是字符串中第一条sql得执行结果
            if (result) {
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    String res = rs.getString("id");
                    System.out.println(res);
                }
            } else {
                int count = ps.getUpdateCount();
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcAfter.commit(con);
    }

    /**
     * 设置allowMultiQueries=true; 后可以一个字符串里写多条sql.获取得结果是字符串中第一条sql得执行结果.
     * 可以在一个请求里执行多条sql. 回滚也会将这个字符串得所有sql回滚.
     */
    @Test
    public void oneConnectionTwoRequestRollback() {
        String url = "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
        String sql = "INSERT INTO  tbl_b (id,val) values('1','d');INSERT INTO  tbl_b (id,val) values('2','d');INSERT INTO  tbl_b (id,val) values('3','d');";
        String sql2 = "INSERT INTO  tbl_b (id,val) values('4','d');";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = JdbcPrepare.getPrepareStatement(con, sql);
        boolean result = JdbcExe.execute(ps);
        System.out.println(result);
        try {
            if (result) {
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    String res = rs.getString("id");
                    System.out.println(res);
                }
            } else {
                int count = ps.getUpdateCount();
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("这里设置断点");
        ps = JdbcPrepare.getPrepareStatement(con, sql2);
        boolean result2 = JdbcExe.execute(ps);
        System.out.println(result);
        try {
            if (result2) {
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    String res = rs.getString("id");
                    System.out.println(res);
                }
            } else {
                int count = ps.getUpdateCount();
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcAfter.rollback(con);
    }

    /**
     * 一个connection中一次请求,执行多个sql
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JdbcAfter.commit(con);
    }

    /**
     * 一个connection中一次请求,执行多个sql,可以是各种insert,update,delete
     * 语句.也可以配合&allowMultiQueries=true使用,但是不能是select
     */
    @Test
    public void batch() {
        String url = "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
        String sql = "INSERT INTO  tbl_b (id,val) values(?,?);";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = JdbcPrepare.getPrepareStatement(con, sql);
        try {
            ps.setString(1, "3");
            ps.setString(2, "d");
            ps.addBatch();
            System.out.println("这里是断点");
            ps.addBatch("update tbl_b set id=5 where id=2;");
            ps.setString(1, "2");
            int[] a = ps.executeBatch();
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JdbcAfter.commit(con);
    }
}
