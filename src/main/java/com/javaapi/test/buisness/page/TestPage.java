package com.javaapi.test.buisness.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestPage {

    @Test
    public void testPage() {
        int pageNo =2;
        int pageSize = 100;
        if(pageNo <1) {
            System.out.println("pageNo不合法");
            return;
        }
        if(pageSize < 1) {
            System.out.println("pageSize不合法");
            return;
        }
        //---------------
        List<Map<String, String>> mapList = getMapList(100);
        int sum = mapList.size();
        int startIndex = (pageNo - 1)*pageSize; 
        if( startIndex > sum) {
            System.out.println("pageSize或者pageNo过大");
            return ;
        }
        int endIndex = startIndex+pageSize >= (sum) ?   (sum):startIndex+pageSize;
        outPut(mapList, startIndex, endIndex);
    }

    /**
     * @param mapList
     * @param startIndex
     * @param endIndex
     * @create_time 2015年1月12日 下午1:33:59 
     */
    private void outPut(List<Map<String, String>> mapList, int startIndex, int endIndex) {
        List<Map<String, String>> subList = mapList.subList(startIndex, endIndex);
        int i=1;
        for (Map<String, String> map : subList) {
            System.out.println(i+"==>"+map);
            i++;
        }
    }

    /**
     * 
     * @return 
     * @create_time 2015年1月7日 上午10:51:42 
     */
    private List<Map<String, String>> getMapList(int size) {
        List<Map<String, String>> planList;
        planList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(String.valueOf(i), String.valueOf(i));
            planList.add(hashMap);
        }
        return planList;
    }
}
