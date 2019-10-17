package com.javaapi.test.spring.spring.custom.controllerlog;

import com.javaapi.test.spring.spring.custom.controllerlog.controller.TaskController;
import com.javaapi.test.spring.spring.custom.controllerlog.controller.io.TaskRequest;
import com.javaapi.test.spring.spring.custom.controllerlog.controller.io.TaskResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by user on 2019/10/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
    @Autowired
    TaskController taskController;

    @Test
    public void test() throws Exception {
        TaskRequest task = new TaskRequest();
        task.setId(1L);
        task.setName("普通任务");
        TaskResponse start = taskController.start(task);
        System.out.println("start = " + start);
    }
}
