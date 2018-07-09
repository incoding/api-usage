package com.javaapi.test.test.testJavaFeature.Version_1_8.method.defaultMethod;

/**
 * 默认方法可以定义多个
 */
public interface DefaultFunInterface {
    //定义默认方法 count
    default int count() {
        return 1;
    }

    default int size() {
        return 1 + 1;
    }
}

class SubDefaultFunClass implements DefaultFunInterface {
    public static void main(String[] args) {
//实例化一个子类对象，改子类对象可以直接调用父接口中的默认方法 count
        SubDefaultFunClass sub = new SubDefaultFunClass();
        System.out.println("sub = " + sub.count());
        System.out.println("size = " + sub.size());
    }
}