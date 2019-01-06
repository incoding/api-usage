package com.javaapi.test.buisness.data.json.fastjson.sample.jsonobject;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by user on 2019/1/3
 */
@Data
public class Student {
    @JSONField(name = "nameField")
    private String name;
}
