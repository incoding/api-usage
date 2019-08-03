package com.javaapi.test.buisness.pattern.action.interceptor;

import java.util.Iterator;


public class ActionInvocation {
	 Iterator<Interceptor> iterator;
	 private Action action;
	 private Object returnValue ;
	 public Object invoke() {
	        if(iterator == null ){
	        	return action.invoke();
	        }
			if (iterator.hasNext()) {
	            Interceptor interceptor = iterator.next();
	            try {
	                interceptor.intercept(this);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } else{
	        	 returnValue = action.invoke();
	        }
			return returnValue;
	    }
	public Iterator<Interceptor> getIterator() {
		return iterator;
	}
	public void setIterator(Iterator<Interceptor> iterator) {
		this.iterator = iterator;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	  
	  
}
