package com.javaapi.test.pattern.action.chain;

import org.omg.CORBA.Request;

public interface RequestHandle {

	void handleRequest(Request request);
}
