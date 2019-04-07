package com.javaapi.test.test.javafeature.version5.generictype.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 1 测试泛型super关键字 </br>
 * 2 extends 可用于的返回类型限定，不能用于参数类型限定。 </br> 
 *  super 可用于参数类型限定，不能用于返回类型限定。 </br>
 *  带有super超类型限定的通配符可以向泛型对易用写入，带有extends子类型限定的通配符可以向泛型对象读取
 * 
 */
public class GenericSuper {
    public static void main(String[] args) {
        List<Integer> aa = new ArrayList<Integer>();
        aa.add(123);
        aa.add(123);
        // 报错,write只能放入Number的父类的集合
//        write(aa);
        List<Number> bb= new ArrayList<Number>();
        bb.add(123);
        bb.add(123);
        // 正确,放入本身是可以的
        write(bb);
        List<Object> cc = new ArrayList<Object>();
        cc.add(new Object());
        cc.add(new Object());
        // 正确
        write(cc);
    }

    public static void write(List<? super Number> list) {
    	// 查询的时候只能转为Object,因为不知道具体的类型
    	for (Object object : list) {
    		if(object instanceof Number){
    			System.out.println((Number)object);
    		}
		}
    	// 插入的时候可以放入子类
        list.add(123);
        list.add(123.0);
        list.add(Double.parseDouble("123"));
    }
}
