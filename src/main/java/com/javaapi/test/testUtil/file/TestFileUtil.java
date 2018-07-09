package com.javaapi.test.testUtil.file;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * Paths,Path,Files
 * http://evil850209.iteye.com/blog/1923417
 * java.nio.file.Paths 包含了用于创建Path对象的静态方法
 java.nio.file.Path 包含了大量用于操纵文件路径的方法
 java.nio.file.FileSystems 用于访问文件系统的类
 java.nio.file.FileSystem 代表了一种文件系统，例如Unix下的根目录为 / ，而Windows下则为C盘
// java.nio.file.FileStore 代表了真正的存储设备，提供了设备的详尽信息
// java.nio.file.attribute.FileStoreAttributeView 提供了访问文件的信息


 http://www.infoq.com/cn/articles/java7-nio2
 */
public class TestFileUtil {
    @Test
    public void test() {
        File file = new File("/Users/user/Downloads/项目整理new.xlsx");
        System.out.println(file.getName());
    }

    @Test
    public void testFileUtils() {
        String first = "/Users/user/Downloads/tmp.txt";
        String tmp= "/Users/user/Downloads/tmp_tmp.txt";
        Path path = Paths.get(first);
        List<String> strings = null;
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (CollectionUtils.isEmpty(strings)) {
            return;
        }
        System.out.println("strings = " + strings);
        try {
            Files.write(Paths.get(tmp),strings, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
