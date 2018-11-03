package com.javaapi.test.util.func.poi.sample1;

import com.javaapi.test.util.func.poi.poiUtil.PoiUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.util.List;

/**
 * Created by user on 18/1/10.
 */
public class Client {
    @Test
    public void test() {
        String filePath = "/Users/user/Desktop/静态.xls";
        HSSFWorkbook readDocument = PoiUtil.readDocument(filePath);
        List<List<List<String>>> allSheetInfo = PoiUtil.getAllSheetInfo(readDocument);
        System.out.println("allSheetInfo = " + allSheetInfo.size());
        List<List<String>> lists = allSheetInfo.get(0);
        System.out.println("allSheetInfo = " + lists.size());
        System.out.println("allSheetInfo = " + lists.get(0));
        System.out.println("allSheetInfo = " + lists.get(1));
        List<String> strings = lists.get(1);
        System.out.println("strings = " + strings);




    }
}
