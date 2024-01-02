package com.javaapi.test.buisness.data.yaml.snakyaml;

import com.javaapi.test.buisness.data.yaml.Person;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class Client {

    @Test
    public void test() throws IOException {
        Yaml yaml = new Yaml();
        String pathname = this.getClass().getResource("/person.yaml").getPath();
        Person person = yaml.loadAs(FileUtils.readFileToString(new File(pathname), "UTF-8"), Person.class);
        System.out.println("load = " + person);
        String s = person.getIotOpenResopnse().get("099975");
        System.out.println("s = " + s);

    }
}
