package com.javaapi.test.util.time.joda.operations.timezone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

import java.util.Date;

/**
 * https://stackoverflow.com/questions/19002978/in-joda-time-how-to-convert-time-zone-without-changing-time
 */
public class DateUtils {

    /**
     * 转换成北京时间
     *
     * @param date     时间,  比如 2019-10-25 10:47:06
     * @param fromZone 时间对应的时区
     * @return 北京时间
     */
    public static Date trasferTimeToBJ(Date date, Integer fromZone) {
        // 北京是东8区
        return transferTime(date, fromZone, 8);
    }

    /**
     * 给定一个时间,和一个时区,
     * 转换成指定时区
     *
     * @param date     时间,  比如 2019-10-25 10:47:06
     * @param fromZone 时间对应的时区
     * @param toZone   转换至某个时区
     */
    public static Date transferTime(Date date, Integer fromZone, Integer toZone) {
        // 将时区擦除
        LocalDateTime localDateTime = new LocalDateTime(date);
        // 转换成来源时区
        DateTime dateTime = localDateTime.toDateTime(DateTimeZone.forOffsetHours(fromZone));
        // 转换至 指定时区
        DateTime toDateTime = dateTime.withZone(DateTimeZone.forOffsetHours(toZone));
        return toDateTime.toLocalDateTime().toDate();
    }
}
