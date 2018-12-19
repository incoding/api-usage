package com.javaapi.test.test.type.object.perfermance;

import com.javaapi.test.test.type.object.FromBean;
import com.javaapi.test.test.type.object.ToBean;

public interface IMethodCallBack {

    String getMethodName();

    ToBean callMethod(FromBean frombean)  throws Exception;

}