package com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.mapper;

import org.mapstruct.Named;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2020/10/2.
 */
@Named("dateTimeMapper")
public class DateTimeMapper {
    public String asString(Date date) {
        return date != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(date) : null;
    }

    public Date asDate(String date) {
        try {
            return date != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(date) : null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
