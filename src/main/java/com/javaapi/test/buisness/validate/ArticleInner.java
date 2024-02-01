package com.javaapi.test.buisness.validate;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ArticleInner {

    private Long id;

    @NotEmpty(message = "标签不能为空")
    private String tag;

    @NotNull(message = "内部创建时间不能为空")
    private Date createTime;


}
