package com.javaapi.test.test.testReflect.serializable.ser2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**第一种序列化方式
 * http://blog.csdn.net/p106786860/article/details/17953223
 * writeObject / readObject
 */
public class SerializeDemo extends AbstractSerializeDemo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int z;

    public SerializeDemo() {
        super.init(10, 50);
        z = 100;
    }

    public void printZ() {
        super.printXY();
        System.out.println("z:" + z);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        SerializeDemo sd = new SerializeDemo();
        sd.printZ();
        out.writeObject(sd);
        System.out.println("-----------");
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        SerializeDemo sd2 = (SerializeDemo) in.readObject();
        sd2.printZ();
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();//java对象序列化默认操作
        os.writeInt(getX());
        os.writeInt(getY());
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();//java对象反序列化默认操作
        int x = is.readInt();
        int y = is.readInt();
        z = x + y; // 1
        //        super.init(x, y); //2
    }
}