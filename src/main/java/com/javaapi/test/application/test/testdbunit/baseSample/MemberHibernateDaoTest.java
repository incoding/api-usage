package com.javaapi.test.application.test.testdbunit.baseSample;


import java.io.FileInputStream;
import java.util.List;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

/**
 * http://blog.csdn.net/abing37/article/details/5019882</br>
 * 会按着memberSet里的数据初始化数据,也就是数据库里原有的数据都会被干掉</br> h2,hsqldb</br>
 * <p>
 * http://www.ltesting.net/ceshi/open/kydycsgj/dbunit/2007/0622/63561.html</br>
 * 　DBUnit框架提供了一个基本的抽象测试用例类，叫做DatabaseTestCase，它是JUnit框架中的基础类TestCase的子类。
 * 如果我们使用这个类必须首先实现两个钩子方法(hook 　　methods)：getConnection()和getDataSet(). 　　
 * 　　方法getConnection()需要返回一个IDatabaseConnection类型的对象，这个对象是一个基于普通JDBC连接的包装类。例如，
 * 下面的代码段演示了在MySQL数据库环境下，IDatabaseConnection类型连接对象的创建方法。
 * </p>
 * 
 * 
 */
public class MemberHibernateDaoTest extends DBTestCase {
 
         IMemberDao memberDao = new MemberHibernateDao();
 
//设置数据库DB Connection的相关信息，因为dbunit测试用例需要对数据库操作。
	public MemberHibernateDaoTest() {
		System.setProperty(
				PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
				"com.mysql.jdbc.Driver");
		System.setProperty(
				PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
				"jdbc:mysql://localhost:3306/contentsearch?useUnicode=true&characterEncoding=UTF-8");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
				"root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
				"root");
	}
 
	/**
	 * 执行测试之前对数据库数据集的操作
	 */
	@Override
         protected DatabaseOperation getSetUpOperation() throws Exception {
                   return DatabaseOperation.CLEAN_INSERT;
         }

	/**
	 * 执行测试之后对数据库数据集的操作
	 */
         @Override
         protected DatabaseOperation getTearDownOperation() throws Exception {
                   return DatabaseOperation.NONE;
         }
 
         protected void setUp() throws Exception {
                   super.setUp();
         }
 
         public void testInsert() {
                   Member member = new Member();
                   member.setName("sky");
                   member.setId(4);
                   memberDao.insertMember(member);
                   Member member2 = memberDao.findMemberById(5);
                   assertEquals(member.getName(), "sky");
         }
 
         public void testListAllMember() {
                   List<Member> members = memberDao.listAllMember();
                   assertEquals(members.size(), 3);
         }
 
         public void testListMemberById() {
                   Member member2 = memberDao.findMemberById(1);
                   assertEquals("sky",member2.getName());
         }
 
    //设置
         @Override
         protected IDataSet getDataSet() throws Exception {
		String path = MemberHibernateDaoTest.class.getResource("").getPath();
		String filepath = path + "memberSet.xml";
		return new FlatXmlDataSetBuilder().build(new FileInputStream(filepath));
         }
}