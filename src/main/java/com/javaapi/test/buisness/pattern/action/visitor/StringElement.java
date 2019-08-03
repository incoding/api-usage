package com.javaapi.test.buisness.pattern.action.visitor;

//访问者模式最大的好处就是,增加
public class StringElement implements Visitable {

	private String se;

	public StringElement(String se) {
		this.se = se;
	}

	public String getSe() {
		return this.se;
	}

	public void accept(Visitor visitor) {
		visitor.visitString(this);
	}
}
