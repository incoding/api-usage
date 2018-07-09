package com.javaapi.test.test.testProxy;

import org.junit.Test;

public class TestDynamicProxy {
    @Test
    public void test() {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
    }


}