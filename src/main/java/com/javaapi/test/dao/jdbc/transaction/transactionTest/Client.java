package com.javaapi.test.dao.jdbc.transaction.transactionTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.javaapi.test.dao.jdbc.JdbcExe;
import com.javaapi.test.dao.jdbc.JdbcPrepare;

/**
 * 1 spring 事务 2 PlatformTransactionManager
 * http://blog.csdn.net/qqqrui/article/details/12910005
 * http://www.iteye.com/topic/480432
 * 
 * 
 */
/**
 * 从Spring容器中获取Service层对象，调用Service层对象持久化对象，大家有没有注意到Spring事务全部在Service层定义，为什么会在Service层定义，而不是Dao层定义呢？这是因为在服务层可能牵扯到业务逻辑，而每个业务逻辑可能调用多个Dao层方法，为保证这些操作的原子性，必须在Service层定义事务。
 *
 */
/**
 * 测试 spring编程式事物
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	PlatformTransactionManager dataSourceTransactionManager;
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static DefaultTransactionDefinition def = new DefaultTransactionDefinition();;
	static {
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
	}

	/**
	 * 通过如上方式包装数据源后，可以在项目中使用物理事务编码的方式来获得逻辑事务的支持，即支持直接从DataSource获取连接和释放连接，且这些连接自动支持Spring逻辑事务； ???
	 */
	@Test
	public void test(){
		
	}
	
	/**
	 * Spring管理的事务是逻辑事务(在基础事务上实现了一些逻辑功)
	 */
	/**
	 * 
	 * 模板类：使用Spring提供的模板类，如JdbcTemplate、HibernateTemplate和JpaTemplate模板类等，
	 * 而这些模板类内部其实是使用了低级别解决方案中的工具类来管理连接或会话；</br> Spring提供两种编程式事务支持：
	 * 直接使用PlatformTransactionManager实现和使用TransactionTemplate模板类
	 * ，用于支持逻辑事务管理。</br> 如果采用编程式事务推荐使用TransactionTemplate模板类和高级别解决方案。
	 */
	@Test
	public void testProgramTransaction() {
		TransactionStatus status = dataSourceTransactionManager
				.getTransaction(def);
		String betid = "595959";
		String sql = "select * from matchs where bet007_id="+betid;
		List<Map<String, Object>> list=	jdbcTemplate.queryForList(sql);
		System.out.println(list.get(0).get("league_name"));
		// 到底是jdbcTemplate还是普通connection?,  普通的肯定不行，是要通过DataSourceUtils 获取得才可以。（待验证)
//		 dataSourceTransactionManager.rollback(status);
		dataSourceTransactionManager.commit(status);
	}
	/**
	 * 高级别的解决方式:这种调用方式也是支持事物的
	 * 如果采用编程式事务推荐使用TransactionTemplate模板类和高级别解决方案。
	 */
	@Test
	public void testProgramTransactionRollBack() {
		TransactionStatus status = dataSourceTransactionManager	.getTransaction(def);
		String bet007_id = "595959";
		String sql = "update matchs set league_name='斯伐乙西1'  where bet007_id="+bet007_id;
		 int result=jdbcTemplate.update(sql);
		 System.out.println(result);
		 dataSourceTransactionManager.rollback(status);
//		dataSourceTransactionManager.commit(status);
	}
	/**使用TransactionTemplate模板类</br>
	 * 如果采用编程式事务推荐使用TransactionTemplate模板类和高级别解决方案。
	 * http://sishuok.com/forum/blogPost/list/2506.html
	 * 如果发生异常需要自己处理并且显示调用status.setRollbackOnly() 后,模板才能在回调中回滚
	 */
	@Test
	public void testTransactionTemplate(){
		TransactionTemplate template=new TransactionTemplate(dataSourceTransactionManager);
		int result = template.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
//				try{
//					
//				}catch(Exception e){
//					// 需要显示回滚
//					status.setRollbackOnly();
//				}
//				String bet007_id = "595959";
//				String sql = "update matchs set league_name='斯伐乙西1'  where bet007_id="+bet007_id;
				String id = "1";
				String sql = "update csc_sns_dev.tbl_b set val='kk'  where id="+id;
				int result=jdbcTemplate.update(sql);
				System.out.println(result);
				//如果需要回滚,则 需要显示回滚
				boolean needRollBack = true;
				// 没什么特别之处,
				if(needRollBack){
					status.setRollbackOnly();
					return 0;
				}else{
					return result;
				}
				
			}
		});
		System.out.println(result);
	}
	/**
	 * 使用工具类获取连接（会话）和释放连接（会话），如使用org.springframework.jdbc.
	 * datasource包中的ConnectionUtils类来获取和释放具有---逻辑事务---功能的连接。</br>
	 * 当然对集成第三方ORM框架也提供了类似的工具类
	 * ，如对Hibernate提供了SessionFactoryUtils工具类，JPA的EntityManagerFactoryUtils等
	 * ，其他工具类都是使用类似***Utils命名
	 */
	/**
	 * 注意 这个是逻辑事物。。。 有待验证</br>
	 * 经实际验证，这种调用方式也是支持事物的，具体实现代码有待考究
	 * http://sishuok.com/forum/blogPost/list/2506.html (好)
	 * spring jdbc 编程事务
	 * 
	 */
	/**
	 * 低级别的解决方式
	 */
	@Test
	public void testDataSourceTransaction() {
		TransactionStatus status = dataSourceTransactionManager
				.getTransaction(def);
		System.out.println("-----------");
		String bet007_id = "595959";
		String sql = "update matchs set league_name='斯伐乙西1'  where bet007_id="+ bet007_id;
		Connection connection = DataSourceUtils.getConnection(datasource);
		PreparedStatement ps = JdbcPrepare.getPrepareStatement(connection, sql);
		int result = JdbcExe.executeUpdate(ps);
		System.out.println(result);
		System.out.println("-----------");
		dataSourceTransactionManager.rollback(status);
		DataSourceUtils.releaseConnection(connection, datasource);
	}
	@Test
	public void testDataSourceTransaction2() {
		System.out.println("-----------");
		String bet007_id = "595959";
		String sql = "update matchs set league_name='斯伐乙西1'  where bet007_id="+ bet007_id;
		Connection connection = DataSourceUtils.getConnection(datasource);
		PreparedStatement ps = JdbcPrepare.getPrepareStatement(connection, sql);
		int result = JdbcExe.executeUpdate(ps);
		System.out.println(result);
		System.out.println("-----------");
		DataSourceUtils.releaseConnection(connection, datasource);
	}
	
	/**
	 * TODO 测试jta分布式事物
	 *
	 */
	@Test
	public void testJtaTransaction(){
		
	}
}
