package com.javaapi.test.test.testJavaFeature.Version_1_7;

import org.junit.Test;

import java.io.IOException;

/**
 * 1.7中支持的新语法
 *

 *
 */
public class Client {

	/**
	 * 在数字中使用下划线</br>
	 */
	@Test
	public void test(){
		int billion = 1_000_000_000;
		System.out.println(billion);
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi = 	3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;


	}
	/**
	 * 你可用作二进制字符前加上 0b 来创建一个二进制类型。
	 */
	@Test
	public void testBinary(){
		int binary = 0b1001_1001;
		System.out.println(binary);
        System.out.println((int)0b100);
	}
	/**
	 * 对字符串进行switch case
     * 注意：在把字符串传进Switch case之前，别忘了检查字符串是否为Null。

     */
	@Test
	public void testSwitchString() {
		String availability = "available";
		switch (availability) {
		case "available":
			// code
			break;

		case "unavailable":
			// code
			break;

		case "merged":
			// code

		default:
			// code
			break;
		}
	}
	/**
	 * 一个catch 多个异常
	 */
	@Test
	public void testMultiplyException() {
		try {
//			Here comes your code….
			throw new IOException();
			}
			catch(IOException  | NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
	}
	/**
	 * FileSystem的API支持

Java7对文件系统支持较为广泛，无论是copy， move，delete等操作，还是文件系统的监视，递归，获取文件的元数据都有了大大的提高。
	 */
	@Test
	public void testFileApi() {
		//TODO
	}

    /**
     * Java SE7新特性之try-with-resources语句
     * http://blog.csdn.net/jackiehff/article/details/17765909
     * @throws Exception
     */
    @Test
    public void testTry_with_resources() throws Exception {

        String zipFileName = "XXXXXX";
        String outputFileName = "XXXXXXX";
        java.nio.charset.Charset charset = java.nio.charset.Charset.forName("US-ASCII");
        java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with try-with-resources statement

        try (
                java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {

            // Enumerate each entry

            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {

                // Get the entry name and write it to the output file

                String newLine = System.getProperty("line.separator");
                String zipEntryName = ((java.util.zip.ZipEntry)entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }
}
