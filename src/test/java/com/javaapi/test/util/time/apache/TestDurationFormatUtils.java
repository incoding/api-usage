package com.javaapi.test.util.time.apache;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by user on 17/12/19.
 */
public class TestDurationFormatUtils {
    @Test
    public void test() {
        Date start = null;
        try {
            start = DateUtils.parseDate("2017-12-19 11:55:12", "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date end = null;
        try {
            end = DateUtils.parseDate("2017-12-20 12:23:12", "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String s = DurationFormatUtils.formatPeriod(start.getTime(), end.getTime(), "H小时m分");
        System.out.println("s = " + s);
    }
}
