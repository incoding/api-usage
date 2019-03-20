package com.javaapi.test.util.application.emojifilter;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by user on 2019/3/19
 */
public class EmojiFilterTest {

    @Test
    public void test() throws IOException {
        String path = EmojiFilterTest.class.getClassLoader().getResource("emoji.txt").getPath();
        List<String> strings = Files.readAllLines(Paths.get(path));
        strings.stream().forEach((s) -> {
            System.out.println("s = " + s);
        });
        String s = EmojiFilter.filterEmoji(strings.toString());
        System.out.println("s = " + s);

    }

    @Test
    public void testName() {
        String s = EmojiFilter.filterEmoji("糖♂分");
        System.out.println("s = " + s);
    }


}
