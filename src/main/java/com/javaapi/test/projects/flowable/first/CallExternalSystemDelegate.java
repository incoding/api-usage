package com.javaapi.test.projects.flowable.first;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * Created by user on 2019/2/13
 */
public class CallExternalSystemDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Calling the external system for employee "
                + execution.getVariable("employee"));
    }

}