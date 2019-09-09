package com.javaapi.test.test.testJdk.language.fieldoveride;

import org.junit.Test;

/**
 * JAVA: 子类“覆盖”父类的成员变量 (静态成员变量和实例成员变量都适用)
 * https://www.polarxiong.com/archives/JAVA-%E5%AD%90%E7%B1%BB-%E8%A6%86%E7%9B%96-%E7%88%B6%E7%B1%BB%E7%9A%84%E6%88%90%E5%91%98%E5%8F%98%E9%87%8F.html
 * JAVA本身并不提供子类“覆盖”父类成员变量的方法，而事实上，从面相对象的角度上来说，子类也不应当可以“覆盖”父类的成员变量。但有时候我们就是有这种需求
 * <p>
 * *  而具体在方法中使用成员变量时，
 * 究竟使用的是父类还是子类的成员变量，
 * 则由方法所在的类决定；
 * 即，方法在父类中定义和执行，则使用父类的成员变量，
 * 方法在子类中定义（包括覆盖父类方法）和执行，则使用子类的成员变量。
 */
public class Client {
    @Test
    public void test() {
        Dad dad = new Dad();
        dad.printName();
        dad.getDadAge();
        dad.getSelfAge();
    }
}
