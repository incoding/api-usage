package com.javaapi.test.application.test.springtest.JunitSpring.stage2;

import com.javaapi.test.application.test.springtest.JunitSpring.School;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 *继承自AbstractTransactionalJUnit4SpringContextTests后</br>
 *1 支持事务回滚</br>
 *2 支持数据库操作,从而对数据正确性进行验证</br>
 *
 *或者对 普通测试类进行 @Transactional 注解http://www.ibm.com/developerworks/cn/java/j-lo-springunitest/</br>
 *   @Transactional 注释标签是表明此测试类的事务启用，这样所有的测试方案都会自动的 rollback，即您不用自己清除自己所做的任何对数据库的变更了
 *
 */
@ContextConfiguration("applicationContext.xml")
public class JuintSpring2 extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	public School school;
	
	@Test
	public void test(){
		school.haveClass();
	}
}
