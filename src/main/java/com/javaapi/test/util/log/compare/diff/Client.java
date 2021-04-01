package com.javaapi.test.util.log.compare.diff;

import com.javaapi.test.util.log.compare.diff.pojo.ComparePojo;
import org.junit.Test;

/**
 * 先通过mapstruct 转换成比较对象,然后再进行比较,这样可以字定义比较输出的样式,
 * <p>
 * <p>
 * 1 CompareObject对需要比较的字段加 LogCompare 注解 , 另外字段都转为String
 * 2 VO 或DO 复制一份转为 CompareObject, 定制转换关系
 * 3 利用OperatorLogUtil 生成改动内容
 */
public class Client {
    @Test
    public void test() {
        ComparePojo comparePojo = new ComparePojo();
        comparePojo.setDate("xxx");
        comparePojo.setAge(30);
        comparePojo.setId(1L);

        ComparePojo comparePojo2 = new ComparePojo();
        comparePojo2.setDate("xxx222");
        comparePojo2.setAge(31);
        comparePojo2.setId(2L);
        String diff = OperatorLogUtils.diff(comparePojo, comparePojo2);
        System.out.println("diff = " + diff);

    }
}
