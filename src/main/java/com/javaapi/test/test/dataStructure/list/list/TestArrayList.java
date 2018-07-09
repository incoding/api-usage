package com.javaapi.test.test.dataStructure.list.list;

import org.junit.Test;

import java.util.*;

public class TestArrayList {
    /**
     * 
     *   求并集
     */
    @Test
    public void testListAddAll() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(13);
        list1.add(23);
        list1.add(33);
        list1.add(43);
        list1.add(53);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(14);
        list2.add(24);
        list2.add(34);
        list2.add(43);
        list2.add(53);
        // 原样添加
        list1.addAll(list2);
        System.out.println(list1);
    }

    /**
     * removeAll,addAll 组合后达到 添加不同得
     * @create_time 2014年9月18日 下午5:31:42 
     */
    @Test
    public void testListMerge() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(13);
        list1.add(13);
        list1.add(13);
        list1.add(23);
        list1.add(33);
        list1.add(43);
        list1.add(53);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(14);
        list2.add(24);
        list2.add(34);
        list2.add(43);
        list2.add(53);
        // 有相同得则移除
        list1.removeAll(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }

    /**
     * 求交集
     * @create_time 2014年9月18日 下午5:31:13 
     */
    @Test
    public void testListRetain() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(13);
        list1.add(23);
        list1.add(33);
        list1.add(43);
        list1.add(53);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(14);
        list2.add(24);
        list2.add(34);
        list2.add(43);
        list2.add(53);
        list1.retainAll(list2);
        System.out.println(list1);

    }

    /**
     * 求差集 求list1 中有,但是list2中没有
     * @create_time 2014年9月18日 下午5:31:13
     */
    @Test
    public void testListRemoveAll() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(13);
        list1.add(23);
        list1.add(33);
        list1.add(43);
        list1.add(53);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(14);
        list2.add(24);
        list2.add(34);
        list2.add(43);
        list2.add(53);
        list1.removeAll(list2);
        System.out.println(list1);

    }

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
    @Test
    public void testListAdd(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("2");
        HashMap<String, List<String>> hashMap = new HashMap<>();
        hashMap.put("list", arrayList);
        hashMap.get("list").add("3");
        printList(hashMap);
    }

    private void printList(HashMap<String, List<String>> hashMap) {
        List<String> list =  hashMap.get("list");
        System.out.println(list);
    }
    /*根据值反查索引*/
    @Test
    public void testGetValueIndex() throws Exception {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(4);
        a.add(5);
        int i = a.indexOf(3);
        System.out.println("i = " + i);
    }

    /**
     *
     * 我们在使用List,Set的时候，为了实现对其数据的遍历，我们经常使用到了Iterator(跌代器)。使用跌代器，你不需要干涉其遍历的过程，只需要每次取出一个你想要的数据进行处理就可以了。
     但是在使用的时候也是有不同的。List和Set都有iterator()来取得其迭代器。对List来说，你也可以通过listIterator()取得其迭代器，两种迭代器在有些时候是不能通用的，Iterator和ListIterator主要区别在以下方面：
     1. ListIterator有add()方法，可以向List中添加对象，而Iterator不能
     2. ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。
     3. ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能。
     4. 都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iierator仅能遍历，不能修改。
     因为ListIterator的这些功能，可以实现对LinkedList等List数据结构的操作。其实，数组对象也可以用迭代器来实现。
     org.apache.commons.collections.iterators.ArrayIterator就可以实现此功能。一般情况下，我们使用Iterator就可以了，如果你需要进行记录的前后反复检索的话，你就可以使用ListIterator来扩展你的功能，（有点象JDBC中的滚动结果集）。
     */
    @Test
    public void testIterator(){

    }

    @Test
    public void testIterator2(){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(4);
        a.add(5);
        int i=0;
        for (Iterator<Integer> iterator = a.iterator();iterator.hasNext();) {
            Integer next = iterator.next();
            System.out.println("next = " + next);
            if (i == 2) {
                selfRemove(iterator);
            }
            i++;
        }
        for (int j = 0; j < a.size(); j++) {
            Integer integer = a.get(j);
            System.out.println("integer = " + integer);
        }



    }

    @Test
    public void testIterator3(){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(4);
        a.add(5);
        List<List<Integer>> aList = new ArrayList<>();
        aList.add(a);
        int i=0;
        for (Iterator<List<Integer>> listIterator = aList.iterator();listIterator.hasNext();) {
            List<Integer> next = listIterator.next();
            for (Iterator<Integer> iterator = next.iterator();iterator.hasNext();) {
                Integer iterNext = iterator.next();
                if (i == 2) {
                    selfRemove(iterator);
                }
                i++;
            }
        }

        System.out.println("a = " + a);
    }

    private void selfRemove(Iterator<Integer> iterator) {
        iterator.remove();
    }
}
