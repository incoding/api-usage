package com.javaapi.test.application.cache.redis.springredis;

import java.io.Serializable;
import java.util.Date;

import com.javaapi.test.application.cache.redis.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hncw
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	@Qualifier("redisTemplate")
	private StringRedisTemplate redisTemplate;
	
	
	@Autowired
	@Qualifier("redisTemplateJdk")
	private RedisTemplate<Serializable,User>  redisTemplateJdk;
	
	@Autowired
	@Qualifier("redisTemplateJackson")
	private RedisTemplate<String, Object>  redisTemplateJackson;  
	
	// string ser
	@Test
	public void testStringSet() {
		redisTemplate.opsForValue().set("nihao", "nihao2");
	}
	@Test
	public void testStringGet() {
		String string = redisTemplate.opsForValue().get("nihaojdk");
		System.err.println(string);
		 String userJackson = redisTemplate.opsForValue().get("nihaoJackson");
		 System.err.println(userJackson);
	}
	
	// jdk ser
	/**
	 * jdk序列化/反序列化 只能搭配  jdk 反序列化/序列化使用
	 */
	@Test
	public void testJdkSet() {
		User value = new User();
		value.setName("nihaojdk");
//		value.setCreateTime(new Date());
		redisTemplateJdk.opsForValue().set("nihaojdk", value);
	}
	/**
	 * jdk序列化/反序列化 只能搭配  jdk 反序列化/序列化使用
	 */
	@Test
	public void testJdkGet() {
		 User user = redisTemplateJdk.opsForValue().get("nihaojdk");
		 System.err.println(user);
		 User userJackson = redisTemplateJdk.opsForValue().get("nihaojdk");
		 System.err.println(userJackson);
	}
	// jackson ser
	@Test
	public void testJacksonSet() {
		User value = new User();
		value.setName("nihaoJackson1");
		value.setCreateTime(new Date());
		redisTemplateJackson.opsForValue().set("nihaoJackson3", value);
	}
	
	/**暂时通过自定义的类来解决 类型问题
	 * http://blog.csdn.net/neosmith/article/details/46800235
	 */
	@Test
	public void testJacksonGet() {
		 User user = (User) redisTemplateJackson.opsForValue().get("nihaoJackson3");
		 System.err.println(user);
	}
}

