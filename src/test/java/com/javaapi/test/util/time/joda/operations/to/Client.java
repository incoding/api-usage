package com.javaapi.test.util.time.joda.operations.to;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * Created by user on 2018/8/29
 */
public class Client {
    @Test
    public void test(){
        int hourOfDay = new DateTime().getHourOfDay();
        System.out.println("hourOfDay = " + hourOfDay);

        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime = dateTimeFormatter.parseDateTime("2018-08-29 09:45:35");
        int hourOfDay1 = dateTime.getHourOfDay();
        System.out.println("hourOfDay1 = " + hourOfDay1);
    }
}
