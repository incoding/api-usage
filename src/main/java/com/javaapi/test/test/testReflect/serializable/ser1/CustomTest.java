package com.javaapi.test.test.testReflect.serializable.ser1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试序列化方式1
 * @project apiTest
 * @author kk
 * @date 2014年8月4日
 * @See ConstantGame
 */
public class CustomTest {

    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("custom.txt"));
            ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("custom.txt"));
            Person3 per = new Person3("孙悟空", 500);
            oos.writeObject(per);
            Person3 p = (Person3) ooi.readObject();
            System.out.println(p.getName() + ":" + p.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}