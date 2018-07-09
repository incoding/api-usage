package com.javaapi.test.test.testJavaFeature.scope;

import com.javaapi.test.test.testJavaFeature.scope.model.InnerEntityPublick;

/**
 * Created by user on 15/9/4.
 */
public class OutIn extends InnerEntityPublick{
    public String getProtected(){
        return this.name;
    }
}
