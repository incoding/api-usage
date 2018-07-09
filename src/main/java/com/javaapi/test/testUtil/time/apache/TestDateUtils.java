package com.javaapi.test.testUtil.time.apache;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by user on 17/8/16.
 */
public class TestDateUtils {
    @Test
    public void test(){
        Date old = null;
        try {
            old = DateUtils.parseDate("2016-12-31 11:17:52", "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date date = DateUtils.addDays(old, 1);
        System.out.println("date = " + date);
    }

    @Test
    public void testPlusOneDayWhenSameDay(){
        Date dep = null;
        Date arr = null;
        try {
            dep = DateUtils.parseDate("2016-12-31 21:17:52", "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            arr = DateUtils.parseDate("2016-12-31 01:17:52", "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        arr = plusOneDayWhenSameDay(dep, arr);
        System.out.println("date = " + arr);

    }


    public static Date plusOneDayWhenSameDay(Date depTime,Date arrTime){
        if (depTime == null || arrTime == null) {
            return arrTime;
        }
        if (arrTime.getTime() > depTime.getTime()) {
            return arrTime;
        }

        arrTime = DateUtils.addDays(arrTime, 1);
        return arrTime;
    }
}
