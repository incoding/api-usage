package com.javaapi.test.test.testJavaFeature.innerClass.featureStaticInner;

/**
 *
 *  * 　3.静态内部类有特殊的地方吗？

    1   静态内部类不能   访问外部类的非static成员
 *   静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法，这点很好理解，因为在没有外部类的对象的情况下，可以创建静态内部类的对象，如果允许访问外部类的非static成员就会产生矛盾，
 *   因为外部类的非static成员必须依附于具体的对象。
 *
 *
 *
 *
     2          静态内部类是不持有指向外部类对象的引用
 　　从前面可以知道，静态内部类是不依赖于外部类的，也就说可以在不创建外部类对象的情况下创建内部类的对象。另外，静态内部类是不持有指向外部类对象的引用的，这个读者可以自己尝试反编译class文件看一下就知道了，是没有Outter this&0引用的。

 */
public class ClientStaticInner {


    public String out = "nihao";



    public static class ClientStaticInnerPublic {
        private String	name;
        private String	age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void getOut(){
            // 编译错误
//            System.out.println("name = " + out);
//            System.out.println("name = " + ClientStaticInner.this.out);
        }
    }
}
