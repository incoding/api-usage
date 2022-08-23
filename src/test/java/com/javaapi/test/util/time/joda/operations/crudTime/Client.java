package com.javaapi.test.util.time.joda.operations.crudTime;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 18/4/25
 */
public class Client {
    @Test
    public void test(){
        DateTime dateTime = new DateTime().minusMonths(2).withDayOfMonth(1).withTimeAtStartOfDay();
        System.out.println("dateTime = " + dateTime);
    }

    @Test
    public void test2() throws Exception {
        Date newStart = new DateTime().minusMonths(2).withDayOfMonth(1).withTimeAtStartOfDay().toDate();
        Date newEnd = new DateTime().withDayOfMonth(1).withTimeAtStartOfDay().toDate();
        System.out.println("newEnd = " + newEnd);
        System.out.println("newEnd = " + newStart);
    }

    @Test
    public void test3(){
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
//时间解析
        DateTime dateTime = DateTime.parse("2018-06-23 07:59:59", format);
        DateTime dateTime1 = dateTime.plusDays(30);
        System.out.println("dateTime1 = " + dateTime1.toString("yyyy-MM-dd HH:mm:ss"));
        DateTime dateTime2 = dateTime.plusDays(60);
        System.out.println("dateTime2 = " + dateTime2.toString("yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test4(){
        int dayOfWeek = new DateTime().getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.DAY_OF_WEEK);
        System.out.println("i = " + i);

    }

}