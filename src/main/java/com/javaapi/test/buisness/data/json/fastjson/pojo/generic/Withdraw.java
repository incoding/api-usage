package com.javaapi.test.buisness.data.json.fastjson.pojo.generic;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class Withdraw implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JSONField(name="index")
	private String index_index;
	private String desc;


	public String getIndex_index() {
		return index_index;
	}

	public void setIndex_index(String index_index) {
		this.index_index = index_index;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Withdraw [index_index=");
		builder.append(index_index);
		builder.append(", desc=");
		builder.append(desc);
		builder.append("]");
		return builder.toString();
	}


}
