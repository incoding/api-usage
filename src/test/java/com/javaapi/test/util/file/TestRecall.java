package com.javaapi.test.util.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import jodd.io.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestRecall {

    @Test
    public void test() throws IOException {
        String[] strings = FileUtil.readLines("/Users/wk/Desktop/param.txt");
        Map<String, Object> map = new LinkedHashMap<>();
        ArrayList<Object> objects = Lists.newArrayList();
        for (String string : strings) {
            String changeString = StringEscapeUtils.unescapeJava(string);
            JSONObject jsonObject = JSON.parseObject(changeString);
            jsonObject.remove("remark");
            jsonObject.put("deviceAddress", "");
            objects.add(StringEscapeUtils.escapeJson(jsonObject.toJSONString()));
        }
        FileUtils.writeLines(new File("/Users/wk/Desktop/param_temp2.txt"), objects);

//        for (String string : strings) {
//            String changeString = StringEscapeUtils.unescapeJava(string);
//            JSONObject jsonObject = JSON.parseObject(changeString);
//            jsonObject.remove("remark");
//            jsonObject.put("deviceAddress", "");
//            String applicationCode = jsonObject.getString("applicationCode");
//            map.put(applicationCode, StringEscapeUtils.escapeJson(jsonObject.toJSONString()));
//        }
//        FileUtils.writeLines(new File("/Users/wk/Desktop/param_temp.txt"), map.values());
    }


}
