package com.javaapi.test.buisness.pattern.action.visitor3;

/**
 * 
 */
public class ConcreteVisitorA implements Visitor{

	@Override
	public void visit(ConcreteElementB able) {
	    System.out.println("ConcreteElementB 行为A");
		able.operate();
	}

	@Override
	public void visit(ConcreteElementA able) {
        System.out.println("ConcreteElementA 行为A");
		able.operate();
	}

    @Override
    public void visit(ConcreteElementC able) {
        System.out.println("ConcreteElementC 行为A");
        able.operate();
    }

    @Override
    public void visit(ConcreteElementD able) {
        System.out.println("ConcreteElementD 行为A");
        able.operate();
    }

    @Override
    public void visit(ConcreteElementE able) {
        System.out.println("ConcreteElementE 行为A");
        able.operate();
    }
	

}