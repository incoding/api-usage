package com.javaapi.test.pattern.action.visitor3;

/** 
 *  
 *作者：alaric 
 *时间：2013-9-13下午11:33:40 
 *描述：具体元素B 
 */  
public class ConcreteElementC implements Visitable {  
  
    @Override  
    public void accept(Visitor v) {  
        v.visit(this);  
    }  
  
    public void operate(){  
        System.out.println("ConcreteElementB ....");  
    }  
}  