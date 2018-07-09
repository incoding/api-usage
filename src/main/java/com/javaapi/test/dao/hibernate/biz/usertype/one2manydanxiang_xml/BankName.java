package com.javaapi.test.dao.hibernate.biz.usertype.one2manydanxiang_xml;

import java.util.HashMap;
import java.util.Map;

public enum BankName {

	ICBC("57","招商银行");
	private String index;
	private String name;
	private static Map<String,BankName> map =new HashMap<>();
	static {
		map.put("57", ICBC);
	}
	public static BankName getByIndex(String index) {
		return map.get(index);
	}
	private BankName(String index, String name) {
		this.index = index;
		this.name = name;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
