package com.javaapi.test.arithmetic.quchong.digui;

public class Perm {
	
	private int id;
	private int parentId;
	
	public Perm(int parentId, int id) {
		this.parentId = parentId;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Perm [id=");
		builder.append(id);
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append("]");
		return builder.toString();
	}

	
	
}
