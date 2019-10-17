package com.javaapi.test.spring.spring.custom.controllerlog.controller.io;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by user on 2019/10/15
 */
@Data
@AllArgsConstructor
public class TaskResponse {
    private Boolean success;
    private String code;
    private String errorMessage;
}
