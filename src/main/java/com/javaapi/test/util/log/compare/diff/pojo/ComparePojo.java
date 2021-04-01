package com.javaapi.test.util.log.compare.diff.pojo;

import com.javaapi.test.util.log.compare.diff.annotation.LogCompare;
import lombok.Data;

/**
 * Created by user on 2020/10/16.
 */
@Data
@LogCompare(name = "日志对象数据变化")
public class ComparePojo {

    private Long id;
    private String name;

    @LogCompare(name = "年龄")
    private Integer age;
    @LogCompare(name = "创建时间")
    private String date;
}
