package com.javaapi.test.util.time.joda;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * -------------------------------------------
 * |   @author      |               |
 * -------------------------------------------
 * |    @date       |18/3/15 下午5:10          |
 * -------------------------------------------
 * |   @version     | V1.0                    |
 * -------------------------------------------
 */
public class JodaTransferDate {

    @Test
    public void testDatetimeToDate(){
        DateTime dateTime = new DateTime();
        Date date = dateTime.toDate();
        System.out.println("date = " + date);
    }
    @Test
    public void testDatetimeToCalendar(){
        DateTime dateTime = new DateTime();
        //计算完转换为Calendar对象
        Locale local = Locale.getDefault();
        System.out.println("local = " + local);
        Calendar calendar = dateTime.toCalendar(local);
        System.out.println("calendar = " + calendar);
    }


    /**
     * 输出为
     * 2018-03-18 08:11:25 星期日
     */
    @Test
    public void testJodaToString(){
        DateTime dateTime = new DateTime();
        String string_u = dateTime.toString("yyyy-MM-dd HH:mm:ss EE");
        System.out.println("string_u = " + string_u);
    }

    /**
     * 输出为
     * 2018-03-18 08:11:25 星期日
     */
    @Test
    public void testJodaToString2(){
        DateTime dateTime = new DateTime();
        String string_u = dateTime.toString("yyyyMMddHHmmssS");
        System.out.println("string_u = " + string_u);
    }
}
