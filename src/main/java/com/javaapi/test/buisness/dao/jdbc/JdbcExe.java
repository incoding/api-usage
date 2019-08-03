package com.javaapi.test.buisness.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcExe {
    public static ResultSet executeQuery(PreparedStatement ps) {
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static int executeUpdate(PreparedStatement ps) {
        int rs = 0;
        try {
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static boolean execute(PreparedStatement ps) {
        boolean rs = false;
        try {
            rs = ps.execute();
            // ps.getResultSet();// ?
            // ps.getUpdateCount(); // ?
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
