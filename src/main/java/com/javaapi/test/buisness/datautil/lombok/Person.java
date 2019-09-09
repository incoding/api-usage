package com.javaapi.test.buisness.datautil.lombok;

import lombok.Builder;
import lombok.Data;

/**
 * Created by user on 2019/9/5
 */
@Builder
@Data
public class Person {
    private String firstName;
    private String lastName;
}
