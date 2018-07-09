package com.javaapi.test.application.test.testjunit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 这是junit得一系列文章</br>
 * http://blog.csdn.net/luanlouis/article/details/37564355</br>
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ATest.class,BTest.class})
public class Client {

}
