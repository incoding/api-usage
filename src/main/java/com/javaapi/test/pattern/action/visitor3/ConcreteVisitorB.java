package com.javaapi.test.pattern.action.visitor3;

/** 
 *  
 *作者：alaric 
 *时间：2013-9-13下午11:32:55 
 *描述：具体访问者B 
 */  
public class ConcreteVisitorB implements Visitor{  
  
    @Override  
    public void visit(ConcreteElementB able) {  
        System.out.println("ConcreteElementB 行为B");
        able.operate();  
    }  
  
    @Override  
    public void visit(ConcreteElementA able) { 
        System.out.println("ConcreteElementA 行为B");
        able.operate();  
    }

    @Override
    public void visit(ConcreteElementC able) {
        System.out.println("ConcreteElementC 行为B");
        able.operate();  
    }

    @Override
    public void visit(ConcreteElementD able) {
        System.out.println("ConcreteElementD 行为B");
        able.operate();  
    }

    @Override
    public void visit(ConcreteElementE able) {
        System.out.println("ConcreteElementE 行为B");
        able.operate();  
    }  
  
      
  
}  