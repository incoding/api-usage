package com.javaapi.test.buisness.data.json.fastjson.feature.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Type;

/**
 * 泛型类型当做可变参数
 */
@SuppressWarnings("all")
public class Client {


    /**
     * typereference  只能在代码里固定类型,不可以吧类型当参数传递
     */
    @Test
    public void testTypeReference(){
        String str = getJsonString();
        A<B<C>> a = JSON.parseObject(str, new TypeReference<A<B<C>>>() {
        });
        System.out.println("extracted = " + a);
    }


    private static <T> T getCbyB(String str) {
        B<T> b = JSON.parseObject(str, new TypeReference<B<T>>() {
        });
        return b.c;
    }


    /**
     * 支持一层泛型参数,实际有多层不支持
     */
    @Test
    public void testTypeReferenceAdvance(){
        B<C> b = new B<>();
        b.age = 10;
        b.c = new C();
        b.c.name = "dong";
        // 序列化 -> b
        String bStr = JSON.toJSONString(b);
        System.out.println(bStr);
        // 反序列化 -> c
        C c = getCbyB(bStr, C.class);
        System.out.println("c = " + c);
    }

    private static <T> T getCbyB(String str, Class<T> tClass) {
        // TypeReference<A<T>>这里T会被tClass代替，没有什么作用。删除T，也能编译通过，因为java类型擦除，最后才进行类型强转
        // A<T> at = JSON.parseObject(str, new TypeReference<A>(tClass) {});

        // 但是T不能删除，因为TypeReference这个类里面强制要求，如果传Type类型，泛型参数要有两层
        // 因为这个方法就是为了让你替换第二层的type，如果没有第二层根本不需要用这个方法
        B<T> b = JSON.parseObject(str, new TypeReference<B<T>>(tClass) {
        });
        return b.c;
    }


    /**
     *  ParameterizedTypeImpl 支持泛型当做参数
     *  支持多层泛型参数
     */
    @Test
    public void testParameterizedTypeImpl(){
        String str = getJsonString();
        A<B<C>> extracted = extracted(str, C.class, B.class);
        System.out.println("extracted = " + extracted);
    }


    private static <T> A<T> extracted(String str, Class cClass, Type bClass) {
        // 错误做法：a.b这里会被解析成JSONObject，因为new TypeReference<A<T>>(tClass) {}只能替换一层
//        A<T> a = JSON.parseObject(str, new TypeReference<A<T>>(tClass) {
//        });
        // 正确做法
        ParameterizedTypeImpl parameterizedType = new ParameterizedTypeImpl(new Class[]{cClass}, null, bClass);
        A<T> a = JSON.parseObject(str, new TypeReference<A<T>>(parameterizedType) {
        });
        return a;
    }

    @Data
    static class A<T> {
        public T b;
        private String name;

        @Override
        public String toString() {
            return "A{" +
                    "b=" + b +
                    '}';
        }
    }
    @Data
    static class B<T> {
        public int age;
        public T c;

        @Override
        public String toString() {
            return "B{" +
                    "age=" + age +
                    ", c=" + c +
                    '}';
        }
    }

    @Data
    static class C {
        public String name;

        @Override
        public String toString() {
            return "C{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    private static String getJsonString() {
        A<B<C>> a = new A<>();
        a.setName("I'm A");
        B<C> b = new B<>();
        b.setAge(12);
        C c = new C();
        c.setName("kk");
        b.setC(c);
        a.setB(b);
        return JSON.toJSONString(a);
    }
}
