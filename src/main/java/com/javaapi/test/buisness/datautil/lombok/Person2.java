package com.javaapi.test.buisness.datautil.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by user on 2019/9/5
 */
@Accessors(chain = true)
@Data
public class Person2 {
    private String firstName;
    private String lastName;
}
