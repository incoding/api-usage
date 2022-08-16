package com.javaapi.test.application.test.springtest.practice.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.Cookie;

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


    @Test
    public void testGet() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                // 要请求的url路径
                .get("/hello?query2=xxxx")
                // 添加请求header
                .header("x-merchant-id", "12345")
                // 添加cookie，注意：不能用header方法加cookie
                .cookie(new Cookie("", ""))
                // 添加请求参数，注意：直接注入方法，而不是放在QueryString里
                .param("query1", "abcd");
// 发起请求
        ResultActions result = mockMvc.perform(builder);
// 避免后面的print里，输出乱码
        result.andReturn().getResponse().setCharacterEncoding("UTF-8");
// 对响应结果进行断言
        // 断言：响应status必须是200
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                                    // 断言：响应内容必须完全匹配
                                    .andExpect(MockMvcResultMatchers.content().string("Hello,abcd12345"))
                                    // 对结果进行输出
                                    .andDo(MockMvcResultHandlers.print())
                                    .andReturn();

// 获取完整响应内容
        String response = mvcResult.getResponse().getContentAsString();

    }

    @Test
    public void testPost() throws Exception {
        // 构建一个请求，包括url、header、参数
        RequestBuilder builder = MockMvcRequestBuilders
                .post("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"张三\",\"desc\":\"哈哈\",\"sex\":15}")
                .header("x-merchant-id", "12345")
                .param("query1", "abcd");
// 发起请求
        ResultActions result = mockMvc.perform(builder);
// 避免后面的print里，输出乱码
        result.andReturn().getResponse().setCharacterEncoding("UTF-8");
// 断言
        result.andExpect(MockMvcResultMatchers.status().isOk())
              .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
              // 对输出的json里，desc的值进行断言
              .andExpect(MockMvcResultMatchers.jsonPath("$.desc").value("哈哈-12345"))
              .andDo(MockMvcResultHandlers.print()); // 对结果进行输出
    }
}
