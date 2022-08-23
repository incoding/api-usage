package com.javaapi.test.util.net.http.pojoTransfer;

import org.junit.Test;

/**
 * Created by user on 18/3/26
 */
public class ClientReflect {

    private final BeanReflectUtil beanReflectUtil = new BeanReflectUtil();

    /**
     * 这种方式 大D可以正常显示
     * 单个字符的字段  大D正常显示
     */
    @Test
    public void describeStrange() {
        StrangePojo strangePojo = new StrangePojo();
        strangePojo.setD("da D");
//        strangePojo.setDd("daxiao Dd");
        strangePojo.setDD("da DD");
//        strangePojo.setd("xiao d");
        beanReflectUtil.describe(strangePojo);

    }

    private void describe(Object student) {
        beanReflectUtil.describe(student);
    }

}
