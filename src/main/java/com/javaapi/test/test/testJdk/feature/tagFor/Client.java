package com.javaapi.test.test.testJdk.feature.tagFor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 17/5/2.
 */
public class Client {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        tag:
        for (String s : list) {

            if ("3".equals(s)) {
                continue tag;
            }
            System.out.println("s = " + s);

        }

    }

    /**
     * break 与标签
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        outer:
        for(int i=0; i<3; i++)
        {
            System.out.println("Pass "+i+":");
            for(int j=0; j<100; j++)
            {
                if(j==10)
                    break outer;
                System.out.println("i="+i+",j="+j);
            }
            System.out.println("This will not print");
        }
        System.out.println("loops complete.");
    }

    /**
     * continue 与标签
     */
    @Test
    public void test2() {
        outer:
        for (int i = 0; i < 10; i++){
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < 10; j++) {
                    if (j==3) {
                        System.out.println();
                        continue outer;
                    }
                    System.out.println("now i="+i+",k="+k+",j="+j);
                }
            }

        }

        System.out.println();
    }
}
