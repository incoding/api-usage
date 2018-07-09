package com.javaapi.test.test.testType.object.perfermance;

import com.javaapi.test.test.testType.object.FromBean;
import com.javaapi.test.test.testType.object.ToBean;

public interface IMethodCallBack {

    String getMethodName();

    ToBean callMethod(FromBean frombean)  throws Exception;

}