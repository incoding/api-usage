package com.javaapi.test.test.reflect.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.junit.Test;

import com.javaapi.test.buisness.constant.constant.classconstant.Student;

/**http://blog.csdn.net/p106786860/article/details/17953223
 * 测试JDK序列化 
 * @project apiTest
 * @author kk
 * @date 2014年7月31日
 */
public class TestSelf {
    private static String path = "/home/kk/program/kkself.txt";

    @Test
    public void write() {
        OutputStream os;
        Student ss = new Student();
        ss.setName("kk");
        ss.setAge(18);
        try {
            os = new FileOutputStream(path);
            ObjectOutputStream obs = new ObjectOutputStream(os);
            obs.writeObject(ss);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    @Test
    public void read() {
        InputStream is;
        try {
            is = new FileInputStream(path);
            ObjectInputStream oi = new ObjectInputStream(is);
            Student student = (Student) oi.readObject();
            System.out.println(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
