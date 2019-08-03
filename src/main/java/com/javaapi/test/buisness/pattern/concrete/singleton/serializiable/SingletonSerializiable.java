package com.javaapi.test.buisness.pattern.concrete.singleton.serializiable;

import java.io.Serializable;

/**
 * 序列化也不会出问题得单例
 * 
 * @author kk
 * 
 */
public class SingletonSerializiable implements Serializable {
	/**
	 * 考虑jdk兼容需要加入这个serialVersionUID
	 */
	private static final long serialVersionUID = -1858691508958538649L;

	private final SingletonSerializiable	instance			= new SingletonSerializiable();

	private SingletonSerializiable() {
	}

	public SingletonSerializiable getInstance() {
		return instance;
	}

	private Object readResolve() {
		return instance;
	}
}
