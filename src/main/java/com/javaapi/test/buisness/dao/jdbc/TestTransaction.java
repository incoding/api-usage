package com.javaapi.test.buisness.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 需要mysql命令行配合
 * 
 * @author wk
 * 
 */
public class TestTransaction {

    private static final String url      = "jdbc:mysql://127.0.0.1:3306/csc_sns_dev?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8";
    private static final String username = "root";
    private static final String password = "root";

    /**
     * 测试 读未提交,当前事务可以看到其他事务未交得数据(不论其他事务隔离级别是什么).当前事务也可以看到当前事务未提交得数据
     */
    @Test
    public void readUncommitted() {
        String sql = "insert into csc_sns_dev.tbl_b (id,val) values(?,?);";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            ps = con.prepareStatement(sql);
            ps.setString(1, "3");
            ps.setString(2, "c");
            int result = ps.executeUpdate();
            System.out.println("这句设置断点");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcAfter.rollback(con);
        System.out.println("这句设置断点");
        JdbcAfter.close(con, ps, rs);
    }

    /**
     * 测试 读提交, 当前事务不可以看到其他事务未交得数据(不论其他事务隔离级别是什么),
     * 当前事务提交前可以看到其他事务已经提交得数据,当前事务也可以看到当前事务未提交得数据
     */
    @Test
    public void readCommitted() {
        String sql = "insert into csc_sns_dev.tbl_b (id,val) values(?,?);";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ps = con.prepareStatement(sql);
            ps.setString(1, "3");
            ps.setString(2, "c");
            int result = ps.executeUpdate();
            System.out.println("这句设置断点");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // JdbcUtil.rollback(con);
        JdbcAfter.commit(con);
        System.out.println("这句设置断点");
        JdbcAfter.close(con, ps, rs);
    }

    /**
     * 测试 可重复读, 当前事务提交前不可以看到其他事务未提交得数据(不论其他事务隔离级别是什么),当前事务提交前不可以看到其他事务已经提交得数据,
     * 当前事务也可以看到当前事务未提交得数据
     */
    @Test
    public void repeatableRead() {
        String sql = "insert into csc_sns_dev.tbl_b (id,val) values(?,?);";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            ps = con.prepareStatement(sql);
            ps.setString(1, "3");
            ps.setString(2, "c");
            int result = ps.executeUpdate();
            System.out.println("这句设置断点");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcAfter.rollback(con);
        System.out.println("这句设置断点");
        JdbcAfter.close(con, ps, rs);
    }

    /**
     * 测试 串行,事务一个一个地执行,第一个事务没有执行完,第二个事务执行会发生阻塞
     * 
     */
    @Test
    public void serializable() {
        String sql = "insert into csc_sns_dev.tbl_b (id,val) values(?,?);";
        Connection con = JdbcPrepare.getConnection(url, username, password);
        JdbcPrepare.beginTransaction(con);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            ps = con.prepareStatement(sql);
            ps.setString(1, "3");
            ps.setString(2, "c");
            int result = ps.executeUpdate();
            System.out.println("这句设置断点");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcAfter.rollback(con);
        System.out.println("这句设置断点");
        JdbcAfter.close(con, ps, rs);
    }
}
