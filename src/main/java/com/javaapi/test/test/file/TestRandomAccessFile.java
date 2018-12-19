package com.javaapi.test.test.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * http://blog.csdn.net/xhh198781/article/details/6525781</br>
 * 每次运行一下main程序就会产生一个java进程.</br>
 * 由于Java的文件锁是 直接映射操作系统的锁机制的，因此其它进程也能看到文件锁。</br>
 *
 */
public class TestRandomAccessFile {
    
    
    public static void testTryLock(){
        RandomAccessFile f1=null;
        RandomAccessFile f2=null;
        
        FileChannel channel1=null;
        FileChannel channel2=null;
        
        FileLock lock1=null;
        FileLock lock2=null;
        
		try {
			f1 = new RandomAccessFile("test.txt", "rw");
			// f1.writeChars("asd");
			channel1 = f1.getChannel();

			lock1 = channel1.tryLock();
			if (lock1 != null) {
				System.out.println("1:success");
			} else {
				System.out.println("1:fail");
			}
		} catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
            f2=new RandomAccessFile("test.txt","rw");
            //f2.writeChars("123");
            channel2 = f1.getChannel();
            
            lock2 = channel2.tryLock();
            
            if(lock2!=null) System.out.println("1:success");
            else System.out.println("1:fail");
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        try {
            if(lock1!=null) lock1.release();
            if(lock2!=null) lock1.release();
            
            if(channel1!=null) channel1.close();
            if(channel2!=null) channel2.close();
            
            
            if(f1!=null) f1.close();
            if(f2!=null) f2.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

    public static void testLock(){
        RandomAccessFile f1=null;
        RandomAccessFile f2=null;
        
        FileChannel channel1=null;
        FileChannel channel2=null;
        
        FileLock lock1=null;
        FileLock lock2=null;
        
        try {
            f1=new RandomAccessFile("test.txt","rw");
            //f1.writeChars("asd");
            channel1 = f1.getChannel();
            
            lock1 = channel1.lock();
            if(lock1!=null) System.out.println("1:success");
            else System.out.println("1:fail");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
            f2=new RandomAccessFile("test.txt","rw");
            //f2.writeChars("123");
            channel2 = f1.getChannel();
            
            lock2 = channel2.lock();
            
            if(lock2!=null) System.out.println("1:success");
            else System.out.println("1:fail");
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        try {
            if(lock1!=null) lock1.release();
            if(lock2!=null) lock1.release();
            
            if(channel1!=null) channel1.close();
            if(channel2!=null) channel2.close();
            
            
            if(f1!=null) f1.close();
            if(f2!=null) f2.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        testTryLock();
       // testLock();
        
    }

}