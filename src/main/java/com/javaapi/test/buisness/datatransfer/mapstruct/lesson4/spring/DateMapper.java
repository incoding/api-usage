package com.javaapi.test.buisness.datatransfer.mapstruct.lesson4.spring;

import org.mapstruct.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2019/8/14
 */
@Mapper(componentModel = "spring")
public class DateMapper {
    public String asString(Date date) {
        return date != null ? new SimpleDateFormat("yyyy-MM-dd")
                .format(date) : null;
    }

    public Date asDate(String date) {
        try {
            return date != null ? new SimpleDateFormat("yyyy-MM-dd")
                    .parse(date) : null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
