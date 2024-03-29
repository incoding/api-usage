package com.javaapi.test.buisness.data.yaml.jyaml;

import com.javaapi.test.buisness.data.yaml.Person;
import org.ho.yaml.Yaml;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wk on 17-4-4.
 */
public class Client {
    //写入yaml配置文件
    @Test
    public  void write() {
        String pathname = this.getClass().getResource("/person.yaml").getPath();
        /* Initialize data. */
        Person father = new Person();
        father.setName("simon.zhang");
        father.setAge(23);
        father.setSex("man");
        List<Person> children=new ArrayList<Person>();
        for (int i = 8; i < 10; i++) {
            Person child = new Person();
            if (i % 2 == 0) {
                child.setSex("man");
                child.setName("mary" + (i - 7));
            } else {
                child.setSex("fatel");
                child.setName("simon" + (i - 7));
            }
            child.setAge(i);
            children.add(child);
        }
        father.setChildren(children);
        /* Export data to a YAML file. */
        File dumpFile = new File(pathname);

        try {
            Yaml.dump(father, dumpFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //读取yaml配置文件
    @Test
    public  void  read() throws FileNotFoundException {
        String pathname = this.getClass().getResource("/person.yaml").getPath();
        File dumpFile=new File(pathname);
        Person father = (Person) Yaml.loadType(dumpFile, Person.class);
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(father.getName())
                .append("\t")
                .append(father.getSex())
                .append("\t")
                .append(father.getAge())
                .append("\t")
                .append(father.getChildren().size());
        System.out.println(stringBuilder.toString());

    }




}
