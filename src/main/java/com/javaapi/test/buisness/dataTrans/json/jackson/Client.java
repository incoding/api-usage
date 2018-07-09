package com.javaapi.test.buisness.dataTrans.json.jackson;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.javaapi.test.application.cache.redis.config.JacksonConfig;
import org.junit.Test;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.javaapi.test.application.cache.redis.User;

public class Client {
//	@SuppressWarnings("unchecked")
//	public T deserialize(byte[] bytes) throws SerializationException {
//
//		if (SerializationUtils.isEmpty(bytes)) {
//			return null;
//		}
//		try {
//			return (T) this.objectMapper.readValue(bytes, 0, bytes.length, javaType);
//		} catch (Exception ex) {
//			throw new SerializationException("Could not read JSON: " + ex.getMessage(), ex);
//		}
//	}
//
//	public byte[] serialize(Object t) throws SerializationException {
//
//		if (t == null) {
//			return SerializationUtils.EMPTY_ARRAY;
//		}
//		try {
//			return this.objectMapper.writeValueAsBytes(t);
//		} catch (Exception ex) {
//			throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
//		}
//	}
	// TODO 如此皮遏制必须设置createTime ，不设置createTime 反序列化会失败
	@Test
	public void testName() throws Exception {

		User value = new User();
		value.setName("nihaoJackson1");
		value.setCreateTime(new Date());
        //
		ObjectMapper objectMapper = new ObjectMapper();
//        JacksonConfig.globalConfig(objectMapper);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_OBJECT);
		byte[] writeValueAsBytes = objectMapper.writeValueAsBytes(value);
        //
		System.err.println(new String(writeValueAsBytes));
		User readValue = objectMapper.readValue(writeValueAsBytes,0,writeValueAsBytes.length,TypeFactory.defaultInstance().constructType(java.lang.Object.class));
		System.err.println(readValue);
	}
	
	@Test
	public void testJson() throws Exception {
		ObjectMapper objectMapper =new  ObjectMapper();
		HashMap<String,String> map = new HashMap<>();
		map.put("key", "value");
		String writeValueAsString = objectMapper.writeValueAsString(map);
		System.out.println(writeValueAsString);
	}	
}
