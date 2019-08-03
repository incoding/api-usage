package com.javaapi.test.buisness.pattern.structure.bridge;

import org.junit.Test;

/**封装变化</br>
 * 需要处理得问题见下面</br>
 *http://www.cnblogs.com/houleixx/archive/2008/02/23/1078877.html
 * 
 * @project apiTest
 * @author kk
 * @date 2015年2月6日
 */
public class TestClient {

    @Test
    public void test() throws Exception {
        Jacket jk = new Jacket();
        Man man =new Man();
        man.setClothing(jk);
        man.dress();
    }
    @Test
    public void test11() throws Exception {
        Trouser tr = new Trouser();
        Man man =new Man();
        man.setClothing(tr);
        man.dress();
    }
    @Test
    public void test2() throws Exception {
        Jacket jk = new Jacket();
        Man man =new Man();
        WhiteHouse wh = new WhiteHouse();
        man.setClothing(jk);
        wh.setPerson(man);
        wh.say();
    }
    @Test
    public void test3() throws Exception {
        Jacket jk = new Jacket();
        Lady man =new Lady();
        WhiteHouse wh = new WhiteHouse();
        man.setClothing(jk);
        wh.setPerson(man);
        wh.say();
    }
}
