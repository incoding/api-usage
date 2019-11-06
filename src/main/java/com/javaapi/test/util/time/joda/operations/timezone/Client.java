package com.javaapi.test.util.time.joda.operations.timezone;

import org.apache.flink.core.memory.SeekableDataOutputView;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by user on 2019/10/24
 */
public class Client {
    @Test
    public void test() {
        int timeZone = 9;
        DateTime tyo_init = new DateTime().withZone(DateTimeZone.forOffsetHours(timeZone));
        Date tyo_local = tyo_init.toLocalDateTime().toDate();
        System.out.println("tokyo time = " + tyo_local);

        // 转换成北京时间
        DateTime dateTime2 = new DateTime();
        dateTime2 = dateTime2.withZone(DateTimeZone.forOffsetHours(8));
        System.out.println("bj time = " + dateTime2.toLocalDateTime());

        DateTime TYO_TIME = new DateTime(DateTimeZone.forOffsetHours(timeZone));
        System.out.println("TYO_TIME = " + TYO_TIME);

//        for (int i = 1; i < 12; i++) {
//            DateTimeZone dateTimeZone = DateTimeZone.forOffsetHours(i);
//            DateTime dateTime = new DateTime().withZone(dateTimeZone);
//            DateTime dateTime1 = dateTime.withZone(DateTimeZone.forOffsetHours(8));
//            System.out.println("dateTime"+dateTime+"dateTime1 = " + dateTime1);
//
//        }
    }

    @Test
    public void test2() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sf.parse("2019-10-24 21:07:02");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println("timezoneOffset = " + parse);

        DateTime dateTime = new DateTime(parse, DateTimeZone.forOffsetHours(9));
        LocalDateTime localDateTime = new LocalDateTime(parse);
//        localDateTime.toDate(TimeZone.);


        System.out.println("dateTime = " + dateTime);
    }

    @Test
    public void test3() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println("time = " + time);
        DateTime dateTime = new DateTime(time, DateTimeZone.forOffsetHours(9));
        System.out.println("dateTime = " + dateTime);
    }

    @Test
    public void test4() {
        Date date = new Date();
//        LocalDateTime localDateTime = new LocalDateTime(date.getTime());
        LocalDateTime localDateTime = new LocalDateTime(date);
        DateTime dateTime = localDateTime.toDateTime(DateTimeZone.forOffsetHours(9));
//        DateTime dateTime1 = dateTime.withZone(DateTimeZone.forOffsetHours(9));
        System.out.println("localDateTime = " + dateTime);
        DateTime dateTime1 = dateTime.withZone(DateTimeZone.forOffsetHours(8));
        System.out.println("dateTime1 = " + dateTime1);
        Date date1 = dateTime1.toLocalDateTime().toDate();
        System.out.println("date1 = " + date1);
    }
}
