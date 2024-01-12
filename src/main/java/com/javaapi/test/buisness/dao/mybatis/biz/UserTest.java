package com.javaapi.test.buisness.dao.mybatis.biz;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        // create a SqlSessionFactory
        Reader reader = Resources
				.getResourceAsReader("com\\javaapi\\test\\dao\\mybatis\\biz\\mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        // // populate in-memory database
        // SqlSession session = sqlSessionFactory.openSession();
        // Connection conn = session.getConnection();
        // reader = Resources
        // .getResourceAsReader("com\\javaapi\\test\\mybatis\\hqldb.sql");
        // ScriptRunner runner = new ScriptRunner(conn);
        // runner.setLogWriter(null);
        // runner.runScript(reader);
        // reader.close();
        // session.close();
    }

    @Test
    public void shouldGetAUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // List<Social> list;
        int l = 0;
        try {
            SocialMapper mapper = sqlSession.getMapper(SocialMapper.class);
            Social social = mapper.getTop1User();
			// for (int i = 0, length = 70000; i < length; i++) {
//                social.setId(UUID.randomUUID().toString());
//                mapper.setUser(social);
//                if (i % 1000 == 0)
//                    System.out.println("已经插入" + (++l) + "千条数据");
//            }
            // UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // User user = mapper.getUser(1);
            // mapper.getUserList();
        } finally {
            sqlSession.close();
        }
    }
}