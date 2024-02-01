package com.javaapi.test.buisness.validate;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ArticleRaw {

    private Long id;

    private Integer type;

    private String content;

    private Date createTime;


}
