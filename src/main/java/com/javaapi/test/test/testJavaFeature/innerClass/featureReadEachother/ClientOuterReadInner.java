package com.javaapi.test.test.testJavaFeature.innerClass.featureReadEachother;

import org.junit.Test;

/**
 * 测试外部类读取内部类属性 </br> 1 无论内部类修饰符如何,或者属性如何,外部类都可以直接访问内部类属性 </br>
 *
 *
 *
 * 在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问：
 */
public class ClientOuterReadInner {

    /**
     * 在外部类里面初始化内部类的方式
     *
     * 在外部类中初始非静态内部类可以有2种方式
     */
    @Test
    public void testInitInOuter() {
        //1
        ClientOuterReadInner.ClientInnerPrivate innerPrivate = new ClientOuterReadInner.ClientInnerPrivate();
        System.out.println(innerPrivate.getName());

        //2
        ClientOuterReadInner.ClientInnerPrivate innerPrivate2 = new ClientOuterReadInner().new ClientInnerPrivate();
        System.out.println(innerPrivate2.getName());


        ClientInnerPrivate innerPrivate3 = new ClientOuterReadInner().new ClientInnerPrivate();
        System.out.println(innerPrivate3.getName());
        ClientInnerPrivate innerPrivate4 = new ClientOuterReadInner.ClientInnerPrivate();
        System.out.println(innerPrivate4.getName());


        ClientInnerPrivate inner = new ClientInnerPrivate();
        System.out.println(inner.getName());
    }

    @Test
    public void testProtected() {
        ClientInnerProtected clientInner = new ClientInnerProtected();
        clientInner.setName("testProtected");
        System.out.println(clientInner.getName());
        System.out.println(clientInner.name);
    }

    public static class ClientStaticInnerPublic {
        private String name;
        private String age;

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

    }

    private class ClientInnerPrivate {
        private String name;
        private String age;

        {
            name = "ClientInnerPrivate";
        }

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

    }

    protected class ClientInnerProtected {
        private String name;
        private String age;

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

    }

    public class ClientInnerPublic {
        private String name;
        private String age;

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

    }
}
