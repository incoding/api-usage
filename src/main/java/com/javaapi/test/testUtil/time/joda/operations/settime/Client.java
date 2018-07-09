package com.javaapi.test.testUtil.time.joda.operations.settime;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * Created by user on 18/4/17
 */
public class Client {
    @Test
    public void withDayOfMonth(){
        DateTime dateTime = new DateTime().withDayOfMonth(1);
        System.out.println("dateTime = " + dateTime);
    }
    @Test
    public void withTimeAtStartOfDay(){
        DateTime dateTime = new DateTime().withTimeAtStartOfDay();
        System.out.println("dateTime = " + dateTime);
    }
}
