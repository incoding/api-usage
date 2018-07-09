package com.javaapi.test.dao.jdbc.jdbc.hsqldb;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 15/8/27.
 */
public class HsqldbLoadUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //创建SqlSessionFactory
            String resource = HsqldbLoadUtil.class.getResource("mybatis-java.xml").getPath();
            Reader reader = new InputStreamReader(new FileInputStream(resource));
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadScript(String absolutePath) {
        //创建数据库
        SqlSession session = null;
        try {
            Reader reader = null;
            session = getSqlSession();
            Connection conn = session.getConnection();
            reader = new InputStreamReader(new FileInputStream(absolutePath));
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setLogWriter(null);
            runner.runScript(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 获取Session
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    @Test
    public void testSelect() {
        SqlSession sqlSession = getSqlSession();
        List<Map<String, String>> list = sqlSession.selectList("testNamespace.select");
        System.out.println("list = " + list);
    }

    @Test
    public void testLoadScript() throws Exception {
        String resource = HsqldbLoadUtil.class.getResource("CreateDB.sql").getPath();
        HsqldbLoadUtil.loadScript(resource);
        testSelect();
    }
}
