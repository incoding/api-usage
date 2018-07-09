package com.javaapi.test.spring.springboot.annotationOnAnnotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("prototype")
@Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 30, isolation= Isolation.SERIALIZABLE)
public @interface MyDao {
    String value();
}