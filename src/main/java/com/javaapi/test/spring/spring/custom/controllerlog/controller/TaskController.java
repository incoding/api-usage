package com.javaapi.test.spring.spring.custom.controllerlog.controller;

import com.javaapi.test.spring.spring.custom.controllerlog.annotation.WebLog;
import com.javaapi.test.spring.spring.custom.controllerlog.controller.io.TaskRequest;
import com.javaapi.test.spring.spring.custom.controllerlog.controller.io.TaskResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2019/10/15
 */
@RequestMapping("/task")
@RestController
public class TaskController {

    @RequestMapping("/start")
    @WebLog
    public TaskResponse start(@RequestBody TaskRequest task) {
        return new TaskResponse(true, null, null);
    }

}
