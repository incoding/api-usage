package com.javaapi.test.test.reflect.serializable.ser3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**第二种序列化方式
 * http://blog.csdn.net/p106786860/article/details/17953223
 * @project apiTest
 * @author kk
 * @date 2014年7月31日
 */
public class Person5 implements Externalizable {
    private String name;
    private int age;

    // 必须提供无参数的构造函数，否则报java.io.InvalidClassException 
    public Person5() {
        super();
    }

    // 注意此处没有提供无参数的构造器 
    public Person5(String name, int age) {
        super();
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // 将去读的字符串反转后赋值给name Field 
        //        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        this.name = ((StringBuffer) in.readObject()).toString();
        this.age = in.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // 将name Field值反转后写入二进制流 
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }
}