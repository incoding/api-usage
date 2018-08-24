package com.javaapi.test.spring.feature.function.scheduler.springscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.scheduling.support.CronSequenceGenerator;

public class ClientUtil {

	/**
	 *根据cron表达式获取下一个触发时间
	 */
	@Test
	public void testCronSequenceGenerator() throws Exception {
		String expression = "10,15,20,25,30,35,40,45,50,55 * * * * ?";
		CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(expression);
		String str = "2015-07-08 15:10:06";
		System.err.println("param date=>"+str);
		Date parseDate = DateUtils.parseDate(str, "yyyy-MM-dd HH:mm:ss");
		Date next = cronSequenceGenerator.next(parseDate);
		String format = DateFormatUtils.format(next, "yyyy-MM-dd HH:mm:ss");
		System.err.println("next date=>"+format);
	}
	/**
	 * 时间点转cron
	 */
	@Test
	public void testDateToCron(){
		Date date = new Date();
		String format = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		System.err.println(format);
		String cron=getCron(date);
		System.out.println(cron);
	}
	
	/***
	 * 
	 * @param date
	 * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatDateByPattern(Date date,String dateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String formatTimeStr = null;
		if (date != null) {
			formatTimeStr = sdf.format(date);
		}
		return formatTimeStr;
	}
	/***
	 * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014"
	 * @param date  : 时间点
	 * @return
	 */
	public static String getCron(java.util.Date  date){
		String dateFormat="ss mm HH dd MM ? yyyy";
		return formatDateByPattern(date, dateFormat);
	}

}
