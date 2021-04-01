package com.javaapi.test.util.log.stringdesc;

import com.javaapi.test.util.log.stringdesc.pojo.PriceLogVO;
import org.junit.Test;

/**
 * Created by user on 2021/4/1.
 */
public class Client {
    @Test
    public void test() {
        PriceLogVO old = new PriceLogVO();
        old.setResourceType("11");
        old.setMerchantId("22");
        String desc = LogConcatUtil.desc(old);
        System.out.println("desc = " + desc);
    }
}
