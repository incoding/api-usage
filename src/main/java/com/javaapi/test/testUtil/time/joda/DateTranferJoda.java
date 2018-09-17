package com.javaapi.test.testUtil.time.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * -------------------------------------------
 * |   @author      |              |
 * -------------------------------------------
 * |    @date       |18/3/15 上午9:43          |
 * -------------------------------------------
 * |   @version     | V1.0                    |
 * -------------------------------------------
 */
public class DateTranferJoda {
    /**
     date 转 datetime
     */
    @Test
    public void testDateToDateTime(){
        Date date = new Date();
        DateTime dateTime = new DateTime(date);
        System.out.println("dateTime = " + dateTime);
    }
    /**
     calendar 转 datetime
     */
    @Test
    public void testCalendarToDateTime(){
        Calendar instance = Calendar.getInstance();
        DateTime date = new DateTime(instance);
        System.out.println("date = " + date);
    }

    @Test
    public void testStringToJoda(){
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
//时间解析
        DateTime dateTime = DateTime.parse("2012-12-21 23:22:45", format);

        System.out.println("dateTime = " + dateTime);
    }
}
