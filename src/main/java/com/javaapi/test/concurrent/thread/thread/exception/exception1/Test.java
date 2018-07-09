package com.javaapi.test.concurrent.thread.thread.exception.exception1;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 关于jdk线程池中的线程产生异常后,如果不调用future.get,异常会被淹没的问题.
 *
 */
public class Test {
@SuppressWarnings("unchecked")
public static void main(String[] args) {
	try{
		secondMethod();
	} catch (Exception e) {
		if(e instanceof ExecutionException ){
			System.out.println("捕获线程池中线程抛出得异常");
		}
	}
	System.out.println("end");
}

private static void secondMethod() throws Exception {
	ArrayList<Future<String>> futures =	getResult();
	// 1 如果进行了future.get操作则要捕获后继续抛出,不然以后的循环都不会在进行了
	// 2 如果不进行future.get则外层方法是捕获不到异常的,也就是异常被线程池淹没
	// 3 如果捕获后继续抛出1个异常则,程序也不会继续进行
	// 4 如果想统计异常的个数或者异常的内容,可以将异常保存在一个list中
	for(Future<String> futrue:futures){
		try{
			System.out.println(futrue.get());
		}catch(ExecutionException e){
			throw e;
		}
	}
    System.out.println("此处不会被执行");

}

private static ArrayList<Future<String>> getResult() throws Exception {
	ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
	ExecutorService es=Executors.newFixedThreadPool(10);
	for(int i=0;i<10;i++){
		Future<String> future =	es.submit(new DefaultCallableImp(i));
		futures.add(future);
	}
	return futures;
}
}
