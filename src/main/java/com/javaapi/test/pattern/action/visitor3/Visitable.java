package com.javaapi.test.pattern.action.visitor3;

public interface Visitable {  
    
    public void accept(Visitor v);

    public void operate();  
  
}  