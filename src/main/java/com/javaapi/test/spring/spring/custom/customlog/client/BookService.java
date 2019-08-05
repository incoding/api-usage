package com.javaapi.test.spring.spring.custom.customlog.client;

import com.javaapi.test.spring.spring.custom.customlog.aop.CustomLog;
import com.javaapi.test.spring.spring.custom.customlog.enums.ChildNameEnum;
import com.javaapi.test.spring.spring.custom.customlog.enums.ServiceNameEnum;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by user on 2019/8/3
 */
@Component
public class BookService {

    @CustomLog(serviceName = ServiceNameEnum.BOOK, childName = ChildNameEnum.BOOK_PRE)
    public BookResponse book(BookParam bookParam) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setCreateTime(new Date());
        return bookResponse;
    }
}
