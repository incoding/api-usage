package com.javaapi.test.spring.custom.registry.exceptionhandler.model;

/**
 * Created by user on 2019/10/20
 */

public class ExceptionResult<P, R> {


    private boolean needContinue;


    public boolean isNeedContinue() {
        return needContinue;
    }

    public void setNeedContinue(boolean needContinue) {
        this.needContinue = needContinue;
    }


}
