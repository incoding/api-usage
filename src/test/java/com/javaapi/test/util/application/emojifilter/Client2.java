package com.javaapi.test.util.application.emojifilter;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 检测有多少被误判断得username
 * //TODO
 */
public class Client2 {
    public static String filterEmoji(String source) {
        String s = EmojiFilter.filterEmoji(source);
        return s;
    }

    public static String filterEmoji1(String source) {
        if (source != null) {
            Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                source = emojiMatcher.replaceAll("");
                return source;
            }
            return source;
        }
        return source;
    }

    public static String filterEmoji2(String source) {
        if (source != null) {
            Pattern emoji = Pattern.compile("[\ud83d\udc00-\ud83d\udfff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                source = emojiMatcher.replaceAll("");
                return source;
            }
            return source;
        }
        return source;
    }

    public static String filterEmoji3(String source) {
        if (source != null) {
            Pattern emoji = Pattern.compile("[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                source = emojiMatcher.replaceAll("");
                return source;
            }
            return source;
        }
        return source;
    }

    @Test
    public void test() throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("/Users/user/Downloads/user_tmp.txt"));
        List<String> collect = strings.stream().filter((s -> {
            return EmojiFilter.containsEmoji(s);
//            String s1 = filterEmoji(s);
//            if (!s1.equals(s)) {
//                return true;
//            }
//            return false;
        })).collect(Collectors.toList());


        List<String> collect1 = strings.stream().filter((s -> {

            String s1 = filterEmoji1(s);
            if (!s1.equals(s)) {
                return true;
            }
            return false;
        })).collect(Collectors.toList());
        List<String> collect2 = strings.stream().filter((s -> {

            String s1 = filterEmoji2(s);
            if (!s1.equals(s)) {
                return true;
            }
            return false;
        })).collect(Collectors.toList());
        List<String> collect3 = strings.stream().filter((s -> {

            String s1 = filterEmoji3(s);
            if (!s1.equals(s)) {
                return true;
            }
            return false;
        })).collect(Collectors.toList());
        FileUtils.writeLines(new File("/Users/user/Downloads/emoji/user.txt"), collect);
        FileUtils.writeLines(new File("/Users/user/Downloads/emoji/user1.txt"), collect1);
        FileUtils.writeLines(new File("/Users/user/Downloads/emoji/user2.txt"), collect2);
        FileUtils.writeLines(new File("/Users/user/Downloads/emoji/user3.txt"), collect3);

    }


}
