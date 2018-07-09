package com.javaapi.test.test.testFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;


/**
 * 写的进程获得独占锁后,即便是其他进程进行读操作也需要等待
 *
 */
public class FileLockReadTest {
	public static void main(String[] args) {
		FileChannel channel = null;
		FileLock lock = null;
		try {
			RandomAccessFile raf = new RandomAccessFile("logfile.txt", "rw");
			channel = raf.getChannel();
			lock = channel.lock();// 独占锁
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int r;
			while ((r = channel.read(buffer))!=-1) {
				byte[] array = buffer.array();
				String string = new String(array);
				System.out.println(string);
			}
			Thread.sleep(5000);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			if(lock != null) {
				try {
					lock.release();
					lock = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(channel != null) {
				try {
					channel.close();
					channel = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
