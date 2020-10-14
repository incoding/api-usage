package com.javaapi.test.util.net.http.client.unirest.sample;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import jodd.util.PropertiesUtil;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * how to use Unirest,
 */
public class Client {

    private ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.HOURS, new SynchronousQueue<>());
    private String fileName = "/Users/user/Desktop/application.properties";
    private Properties properties = getProperties();
    private String url = properties.getProperty("app.url");
    private String paramName = properties.getProperty("app.param");
    private String readFile = properties.getProperty("app.readFile");
    private String writeFile = properties.getProperty("app.writeFile");
    private String writeFileBak = properties.getProperty("app.writeFile.bak");
    private String app_pojo_enum = properties.getProperty("app.pojo.enum");
    private String app_pojo_text = properties.getProperty("app.pojo.text");
    private String app_pojo_self = properties.getProperty("app.pojo.self");
    private String app_pojo_other = properties.getProperty("app.pojo.other");
    private String ignore = properties.getProperty("app.pojo.ignore");
    private String cookie = properties.getProperty("cookie");
    private File file;

    @Test
    public void test() {
        List<String> params = getParams();
        Semaphore semaphore = new Semaphore(10);
        for (String param : params) {
            if (param.equals(ignore)) {
                continue;
            }
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadExecutor.submit(() -> {
                try {
                    String resultStr = loadUrl(param);
                    append(param + "___" + resultStr + "\n", writeFileBak);
                    JSONObject jsonObject = JSON.parseObject(resultStr);
                    List<String> objects = Lists.newArrayList();

                    JSONObject data = jsonObject.getJSONObject("data");
                    if (data == null) {
                        return;
                    }
                    String app_pojo_enum_str = data.getString(app_pojo_enum);
                    String app_pojo_text_str = data.getString(app_pojo_text);
                    String app_pojo_self_str = data.getString(app_pojo_self);
                    String app_pojo_other_str = getOther(data);
                    objects.add(param);
                    objects.add(app_pojo_enum_str);
                    objects.add(app_pojo_text_str);
                    objects.add(String.valueOf(app_pojo_self_str));
                    objects.add(String.valueOf(app_pojo_other_str));
                    String join = Joiner.on("___").join(objects);
                    append(join + "\n", writeFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("param exception= " + param);
                } finally {
                    semaphore.release();
                }

            });
        }

    }

    private String getOther(JSONObject data) {

        String string = data.getString(app_pojo_other);
        if (StringUtils.isBlank(string)) {
            return string;
        }
        return String.valueOf(new BigDecimal(string).intValue());
    }

    private void append(String str, String writeFile) {
        try {
            file = new File(writeFile);
            FileUtils.write(file, str, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getParams() {
        try {
            List<String> strings = FileUtils.readLines(new File(readFile));
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Properties getProperties() {
        Properties fromFile = null;
        try {

            fromFile = PropertiesUtil.createFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fromFile;
    }

    public String loadUrl(String param) {
        HttpResponse<String> stringHttpResponse = Unirest.get(url).queryString(paramName, param).header("Cookie", cookie).asString();
        return stringHttpResponse.getBody();
    }
}
