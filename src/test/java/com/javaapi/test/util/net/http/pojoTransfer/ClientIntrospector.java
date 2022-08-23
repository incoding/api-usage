package com.javaapi.test.util.net.http.pojoTransfer;

import org.junit.Test;

/**
 * refer https://www.cnblogs.com/dreammyle/p/5610906.html
 * Created by user on 18/3/26
 */
public class ClientIntrospector {
    private final BeanIntrospectorUtil beanIntrospectorUtil = new BeanIntrospectorUtil();

    @Test
    public void test() {

    }

    /**
     * 单个字符的字段  大D会被描述为小d
     */
    @Test
    public void describeStrange(){
        StrangePojo strangePojo = new StrangePojo();
        strangePojo.setD("da D");
//        strangePojo.setDd("daxiao Dd");
        strangePojo.setDD("da DD");
//        strangePojo.setd("xiao d");
        beanIntrospectorUtil.describe(strangePojo);

    }

    private void describe(Object student) {
        beanIntrospectorUtil.describe(student);
    }

}
