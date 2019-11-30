package com.javaapi.test.test.javafeature.version5.notSureNumParam;

import org.junit.Test;

/**
 * Created by user on 15/9/21.
 */
public class Client {

    @Test
    public void test(){
        Integer[] ids = new Integer[]{5,6,7};
        notSureParam(1);
        notSureParam(2,3,4);
        notSureParam(ids);
    }
    public void notSureParam(Integer... ids){
        Integer[] tmp = ids;
        for (Integer id : tmp) {
            System.out.println("id = " + id);
        }
    }
}
