package com.javaapi.test.util.opensource.apache.commons.collections;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * TODO
 * 1 http://blog.sina.com.cn/s/blog_4cef5c7b0102v0f4.html     中说 //    差集=并集-交集
 * 但是感觉上诉说法貌似不对
 * 感觉testSubtract 的才是差集
 *
 * 2 http://dongwei.iteye.com/blog/230445   好

 */
public class TestCollectionUtils {
    private List<Integer> a = new ArrayList<>();

    private List<Integer> b = new ArrayList<>();

    private List<Integer> c = new ArrayList<>();

    {
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);


        b.add(3);
        b.add(4);
        b.add(5);
        b.add(6);
        b.add(7);

        c.add(3);
        c.add(4);
        c.add(6);
        c.add(7);
        c.add(9);
        c.add(10);

    }

    /*利用apache Collections 求交集*/
    @Test
    public void testIntersection() {
        Collection<Integer> intersection = CollectionUtils.intersection(a, b);
        System.out.println("intersection = " + intersection);    //intersection = [3, 4, 5]

    }

    /*求a,b的 交集*/
    @Test
    public void testRetain() {
        Collection<Integer> integers = CollectionUtils.retainAll(a, b);
        System.out.println("integers = " + integers);//integers = [3, 4, 5]

    }

    /*求a,b的并集不去重*/
    @Test
    public void testCollate() {
        List<Integer> collate = CollectionUtils.collate(a, b);
        System.out.println("collate = " + collate);     //collate = [1, 2, 3, 3, 4, 4, 5, 5, 6, 7]

    }

    /*求a,b的并集      去重*/
    @Test
    public void testUnion() {
        Collection<Integer> union = CollectionUtils.union(a, b);
        System.out.println("union = " + union);  //union = [1, 2, 3, 4, 5, 6, 7]

    }

    //集合相减
    @Test
    public void testSubtract() {
        Collection<Integer> subtract = CollectionUtils.subtract(a, b);
        System.out.println("subtract = " + subtract);    //subtract = [1, 2]

    }

    //交集的补集
    @Test
    public void testDisJunction() {
        Collection<Integer> disjunction = CollectionUtils.disjunction(a, b);
        System.out.println("disjunction = " + disjunction);     //disjunction = [1, 2, 6, 7]
    }


    @Test
    public void testLambda() throws Exception {

    }
}
