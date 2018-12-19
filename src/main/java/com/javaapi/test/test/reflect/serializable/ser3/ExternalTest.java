package com.javaapi.test.test.reflect.serializable.ser3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalTest {

    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("external.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("external.txt"));
            Person5 per = new Person5("孙悟空", 500);
            oos.writeObject(per);
            Person5 p = (Person5) ois.readObject();
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