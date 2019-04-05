package com.javaapi.test.util.time.joda.sample;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 瞬时概念,joda中最小单元
 *
 */
public class TestJodaInstant {

    @Test
    public void test(){
        LocalDate localDateTime =  LocalDate.now();
        int i = 30;
        for (int j = 0; j < i; j++) {
            LocalDate localDate = localDateTime.plusDays(j);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String format = dateTimeFormatter.format(localDate);
            System.out.println("format = " + format);
        }


    }

}
