package com.javaapi.test.util.time.joda;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JodaTimeUtil {

    private Logger logger = LoggerFactory.getLogger(JodaTimeUtil.class);

    @Test
    public void test() {
        Instant in = new Instant();
        System.out.println(in.toString());
        Instant plus = in.plus(1000 * 60 * 60);
        System.out.println(plus.toString());
    }

    @Test
    public void testDateTime() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString());
        System.out.println(dateTime.secondOfDay().getDateTime().toString());
    }

    @Test
    public void testSample1() {
        DateTime dep = new DateTime(2018, 3, 15, 23, 0);
        DateTime arr = new DateTime(2018, 3, 15, 1, 0);

        if (dep.isAfter(arr)) {
            logger.info("到达时间比起始时间小,dep={},arr={}",dep,arr);
            arr = arr.plusDays(1);
        }

        if (dep.withTimeAtStartOfDay().isBefore(arr.withTimeAtStartOfDay())) {
            logger.info("隔日航班,dep={},arr={}",dep,arr);
        }



    }

}
