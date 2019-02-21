package com.javaapi.test.application.test.springtest.practice.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by user on 18/3/5.
 */
public class DemoControllerTest extends ParentControllerTest {
    @Test
    public void testDemo() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/demoOrder/demo"))
                                  .andReturn();

        System.out.println(result.getResponse().getContentAsString());
        Assert.assertNotNull(result.getResponse().getContentAsString());
    }
}
