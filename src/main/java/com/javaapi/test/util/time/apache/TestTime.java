package com.javaapi.test.util.time.apache;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestTime {
	
	public static void main(String[] args) throws ParseException {
        long start  = new SimpleDateFormat("yyyyMMdd").parse("20130101").getTime();
        long end = new SimpleDateFormat("yyyyMMdd").parse("20140101").getTime();
        System.out.println(DurationFormatUtils.formatDuration(end-start,"MM" ));
        System.out.println(DurationFormatUtils.formatDuration(1 * 60 * 60 * 1000, "HH-mm-ss"));
    }
    /**
     * 
     * 格式化间隔时间  ，使之可读
     * @throws ParseException 
     */
    @Test
    public void formatDuration() throws ParseException {
    	long start  = new SimpleDateFormat("yyyyMMdd").parse("20130101").getTime();
    	long end = new SimpleDateFormat("yyyyMMdd").parse("20140101").getTime();
    	System.out.println(DurationFormatUtils.formatDuration(end-start,"MM" ));
        System.out.println(DurationFormatUtils.formatDuration(1 * 60 * 60 * 1000, "HH-mm-ss"));
    }

    /**
     * 
     *  格式化间隔时间 ，使之可读
     */
    @Test
    public void formatPeriod() {
        long start = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println(DurationFormatUtils.formatPeriod(start, end, "HH-mm-ss"));
    }
    @Test
    public void test(){
        long unixTime=1450592982;
        Date date = new Date(unixTime * 1000);
        String yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("yyyyMMddHHmmss = " + yyyyMMddHHmmss);
    }

    @Test
    public void testTruncate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = null;
        try {
            date = simpleDateFormat.parse("2017-07-25 11:53:29");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date truncate = DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
        System.out.println("truncate = " + truncate);

        Date parse = null;
        try {
            parse = simpleDateFormat.parse("2017-07-26 11:53:29");
            parse = DateUtils.truncate(parse, Calendar.DAY_OF_MONTH);
            System.out.println("parse = " + parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse.getTime()>date.getTime());
    }
    @Test
    public void testParse(){
        String date = "2017-07-30";
        Date dateParsed = null;
        try {
            dateParsed = DateUtils.parseDate(date, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        String format = dateFormat.format(dateParsed);
        System.out.println("format = " + format);
    }
}
