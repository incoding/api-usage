package com.javaapi.test.pattern.action.visitor3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
 *  
 *  运行下试试</br>
 *  http://alaric.iteye.com/blog/1942517</br>
 *  
 *  迭代器处理同一个集合中相同类型
 *  访问者处理同一个集合中不同类型</br>
 *  用于处理一个list中，相同接口不同实际类型情况,避免了if判断实际类型，以及可以将变化封装出去(封装到visitor中)；
 *  
 */  
public class Client {  
    /**处理没有访问者模式情况
     * 没办法不用if，来处理类型
     * @throws Exception
     * @create_time 2015年2月13日 上午9:38:41 
     */
    @Test
    public void testCommon() throws Exception {
        List<Visitable> list = new ArrayList<>();
        list.add(new ConcreteElementA());
        list.add(new ConcreteElementB());
        list.add(new ConcreteElementC());
        list.add(new ConcreteElementD());
        list.add(new ConcreteElementE());
        Visitor vB = new ConcreteVisitorB();
        for (Visitable visit : list) {
            if (visit instanceof ConcreteElementA) {
                vB.visit((ConcreteElementA) visit);
            } else if (visit instanceof ConcreteElementB) {
                vB.visit((ConcreteElementB) visit);
            } else if (visit instanceof ConcreteElementC) {
                vB.visit((ConcreteElementC) visit);
            } else if (visit instanceof ConcreteElementD) {
                vB.visit((ConcreteElementD) visit);
            } else if (visit instanceof ConcreteElementE) {
                vB.visit((ConcreteElementE) visit);
            } 
        }

    }
    /**没办法将变化封装出去,变换存在于每一个ConcreteElement operate方法中
     * @throws Exception
     * @create_time 2015年2月13日 上午10:22:25 
     */
    @Test
    public void testCommon2() throws Exception {
        List<Visitable> list = new ArrayList<>();
        list.add(new ConcreteElementA());
        list.add(new ConcreteElementB());
        list.add(new ConcreteElementC());
        list.add(new ConcreteElementD());
        list.add(new ConcreteElementE());
        Visitor vB = new ConcreteVisitorB();
        for (Visitable visit : list) {
            visit.operate();
        }
        
    }
    
    @Test
    public void testVisitor() throws Exception {  
        Visitor vA = new ConcreteVisitorA();  
        Visitor vB = new ConcreteVisitorB();  
        List<Visitable> list = new ArrayList<>();  
        list.add(new ConcreteElementA());  
        list.add(new ConcreteElementB());  
        list.add(new ConcreteElementC());  
        list.add(new ConcreteElementD());  
        list.add(new ConcreteElementE());
//        for(Visitable able :list){  
//            able.accept(vA);  
//        }  
        for(Visitable able :list){  
            able.accept(vB);  
        }  
    }
  
  
}  