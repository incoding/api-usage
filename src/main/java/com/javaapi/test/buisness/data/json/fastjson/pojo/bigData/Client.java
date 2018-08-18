package com.javaapi.test.buisness.data.json.fastjson.pojo.bigData;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * //TODO
 */
public class Client {
    @Test
    public void test(){
        String json = null;
        try {
            json = FileUtils.readFileToString(new File("/Users/user/Downloads/testJson/aaa.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (StringUtils.isBlank(json)) {
            return;
        }

    }
}
