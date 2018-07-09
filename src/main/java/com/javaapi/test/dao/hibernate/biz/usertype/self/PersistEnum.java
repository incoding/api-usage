package com.javaapi.test.dao.hibernate.biz.usertype.self;

import java.util.Map;

public interface PersistEnum<E extends Enum<?>> {
	 
    /**
     * 获取被持久化字段的值
     *
     * @return 被持久化字段的值
     */
	Integer getPersistedValue();
     
    /**
     * 由被持久化的字段的值获取枚举类型
     *
     * @param persistedValue
     * @return
     */
    E returnEnum(Integer persistedValue);
     
    /**
     * 获取枚举的所有枚举项
     *
     * @return map
     */
    Map<Integer, E> getAllValueMap();
}