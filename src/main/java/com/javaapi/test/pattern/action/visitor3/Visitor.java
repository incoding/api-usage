package com.javaapi.test.pattern.action.visitor3;
/**
 * 
 *作者：alaric
 *时间：2013-9-13下午11:31:28
 *描述：抽象访问者
 */
public interface Visitor {

	public void visit(ConcreteElementB able );
	public void visit(ConcreteElementA able );
    public void visit(ConcreteElementC able);
    public void visit(ConcreteElementD able);
    public void visit(ConcreteElementE able);
}