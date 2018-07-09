package com.javaapi.test.test.dataStructure.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestSet {
    /**
     * 
     * list 得remove(int i) 这个重载方法遍历时候不能正确的删除，相应位置得元素.
     */
    @Test
    public void testSet(){
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=-3;i<3;i++){
            set.add(i);
            list.add(i);
        }
        for(int i=0;i<3;i++){
            set.remove(i);
            list.remove((Integer)i);
        }
        System.out.println(set + "   " + list);

    }

}
