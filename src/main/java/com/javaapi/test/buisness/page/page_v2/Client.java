package com.javaapi.test.buisness.page.page_v2;

import com.javaapi.test.buisness.dao.domain.page2.DataPage;
import org.junit.Test;

/**
 * @see DataPage
 */
public class Client {

    @Test
    public void test() {
        DataPage<String> list = new DataPage<>(2,100);
        list.setTotalCount(899);

        System.out.println("getStartIndex = " + list.getStartIndex());
        System.out.println("getEndIndex = " + list.getEndIndex());
        System.out.println("getNextPage = " + list.getNextPage());
        System.out.println("getPrevPage = " + list.getPrevPage());
        System.out.println("getTotalPages = " + list.getTotalPages());
        System.out.println("getFirst = " + list.getFirst());
        System.out.println("getPageNo = " + list.getPageNo());
        System.out.println("getDataList = " + list.getDataList());
    }
}
