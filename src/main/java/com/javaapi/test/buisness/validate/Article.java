package com.javaapi.test.buisness.validate;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Article {

    private Long id;

    @NotNull(message = "类型不能为空")
    private Integer type;

    @NotNull(message = "内容不能为空")
    private String content;

    @NotNull(message = "创建时间不能为空")
    private Date createTime;


}
