package com.javaapi.test.application.cache.redis.client;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javaapi.test.application.cache.redis.User;

/**
 * @author hncw
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

	@Autowired
	@Qualifier("redisTemplateJackson")
	private RedisTemplate<String, Object>  redisTemplateJackson;  

	// 必须要带date不然会报错
	@Test
	public void testJacksonSet() {
		User value = new User();
		value.setName("nihaoJackson1");
		value.setCreateTime(new Date());
        value.setEndTime(new Date());
		redisTemplateJackson.opsForValue().set("nihaoJackson1", value);
	}
	

	@Test
	public void testJacksonGet() {
		 User user = (User) redisTemplateJackson.opsForValue().get("nihaoJackson1");
		 System.err.println(user);
	}
    @Test
    public void testJacksonGetIsNotExist() {
        Object nihaoJackson12222 = redisTemplateJackson.opsForValue().get("nihaoJackson12222");
        System.err.println(nihaoJackson12222);
    }
}

