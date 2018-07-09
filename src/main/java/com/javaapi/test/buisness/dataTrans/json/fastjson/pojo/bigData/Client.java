package com.javaapi.test.buisness.dataTrans.json.fastjson.pojo.bigData;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
