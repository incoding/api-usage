package com.javaapi.test.buisness.dao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class JdbcAfter {

    public static void commit(Connection con) {
        try {
            if (con != null) {
                con.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection con) {
        try {
            if (con != null) {
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackSavePoint(Connection con, Savepoint sp) {
        try {
            if (con != null) {
                con.rollback(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   

    /**
     * reset autocommit to
     * 
     * @param con
     */

    public static void resetAutoCommit(Connection con) {
        try {
            if (con != null) {
                if (con.getAutoCommit()) {
                    con.setAutoCommit(false);
                } else {
                    con.setAutoCommit(true);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(CallableStatement callstmt) {
    	if (callstmt != null) {
    		try {
    			callstmt.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };

    public static void close(Connection con, PreparedStatement pstmt,
            ResultSet rs) {
        close(rs);
        close(pstmt);
        close(con);
    }
    public static void close(Connection con, CallableStatement pstmt,
    		ResultSet rs) {
    	close(rs);
    	close(pstmt);
    	close(con);
    }
}
