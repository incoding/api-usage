package com.javaapi.test.buisness.exception.bussiness.exception_v3.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private int code;
    private String msg;
}
