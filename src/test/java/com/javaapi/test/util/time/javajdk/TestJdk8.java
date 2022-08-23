package com.javaapi.test.util.time.javajdk;

import org.junit.Test;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Java 8中新的时间与日期API中的所有类都是不可变且线程安全的，
 * 这与之前的Date与Calendar API中的恰好相反，
 * 那里面像java.util.Date以及SimpleDateFormat这些关键的类都不是线程安全的。
 *
 *
        Instant——它代表的是时间戳
        LocalDate——不包含具体时间的日期，比如2014-01-14。它可以用来存储生日，周年纪念日，入职日期等。
        LocalTime——它代表的是不含日期的时间
        LocalDateTime——它包含了日期及时间，不过还是没有偏移信息或者说时区。
        ZonedDateTime——这是一个包含时区的完整的日期时间，偏移量是以UTC/格林威治时间为基准的。
*/

public class TestJdk8 {

    @Test
    public void testInstant() throws Exception {
        Instant now = Instant.now();
        java.util.Date from = Date.from(now);
        System.out.println("from = " + from);
        Instant instant = from.toInstant();
        boolean equals = instant.equals(now);
        System.out.println("equals = " + equals);
    }

    @Test
    public void testInstant2() {

        Date date = new Date(1464847980000l);
        System.out.println(date);
        System.out.println("date = " + new Date(1464934380000l));

    }


    @Test
    public void testLocaleDate() throws Exception {
        LocalDate today = LocalDate.now();
        LocalDateTime localDateTime = today.atStartOfDay();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("format = " + format);
        System.out.println("format = " + Date.valueOf(localDateTime.toLocalDate()).getTime());
    }

    public static void main(String[] args) {
        long l = LocalDate.now().plusDays(1).atStartOfDay(ZoneId.of("Asia/Shanghai")).toEpochSecond();
        System.out.println("l = " + l);
        System.out.println("l = " + System.currentTimeMillis());
        String s = LocalDate.now().plusDays(1).atStartOfDay(ZoneId.of("Asia/Shanghai")).toLocalDateTime().toString();
        System.out.println("s = " + s);


        LocalDate localDate = LocalDate.now().minusDays(2);
        LocalDate localDate1 = localDate.atStartOfDay().toLocalDate();
        String format = localDate1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("format = " + format);
        System.out.println("localDate = " + Date.valueOf(localDate1).getTime());

    }

    @Test
    public void testJdk8() {
        long l = LocalDate.now().plusDays(1).atStartOfDay(ZoneId.of("Asia/Shanghai")).toEpochSecond();
        System.out.println("l = " + l);
        System.out.println("l = " + System.currentTimeMillis());
        String s = LocalDate.now().plusDays(1).atStartOfDay(ZoneId.of("Asia/Shanghai")).toLocalDateTime().toString();
        System.out.println("s = " + s);

    }

    @Test
    public void testTime() {
        long l = System.currentTimeMillis();
        System.out.println("l = " + l);
    }


    @Test
    public void testName() throws Exception {
        LocalDateTime localDateTime = LocalDate.now().plusDays(1).atStartOfDay();
        System.out.println("localDateTime = " + localDateTime);
//        localDateTime.
        Duration between = Duration.between(LocalDateTime.now(), LocalDate.now().plusDays(1).atStartOfDay());
        long seconds = between.getSeconds();
        System.out.println(seconds);
    }

    @Test
    public void testToDate() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now().minusMonths(3);

        java.util.Date startDate = java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("startDate = " + startDate);

    }
}
