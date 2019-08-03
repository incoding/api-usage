package com.javaapi.test.buisness.dao.jdbc;

import com.javaapi.test.application.frontTemplate.freemarker.FreeMarkerUtil;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJdbcForMatchName {
    // ------------------
    private static final String NAME         = "name";
    private static final String username = "test";
    private static final String password    = "test";
    private static final String leaguePath   = "jdbc:mysql://192.168.66.13:3306/test?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8";

    // ------------------

    @Before
    public void prepare() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jdbc() {
        String path = leaguePath;
        String username = password;
        String password = username;
        String colomun = NAME;
        String sqlString = "SELECT * FROM bk_league where bk_league.name not in ("
                + "SELECT  league.name_cn FROM league inner join bk_league ON league.name_cn = bk_league.name);";
        try {
            Connection con = getCon(path, username, password);
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.execute();
            if (ps.execute()) {
                ResultSet rs = ps.getResultSet();
                dealResult(rs, colomun);
            } else {
                System.out.println("失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dealResult(ResultSet rs, String colomun) {
        List<String> list = new ArrayList<String>();
        try {
            while (rs.next()) {
                System.out.println(rs.getString(colomun));
                list.add(rs.getString(colomun));
            }

            String freemarkerName = "test.ftl";
            String property = "testProperty.ftl";
            String freemarkerHtml = "test.shtml";
            String freemarkerProperty = "test.properties";
            String path2 = TestJdbcForMatchName.class.getResource("").getPath();
            System.out.println(path2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", list);
            FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2,
                    freemarkerHtml);
            FreeMarkerUtil.geneHtmlFile(property, map, path2,
                    freemarkerProperty);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getCon(String path, String username, String password)
            throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection(path, username, password);
        return con;
    }
}
