package com.javaapi.test.testUtil.io.blockIo.multiThread;

import java.net.ServerSocket;
import java.util.Scanner;

public class MultithreadJIoSocketTest

{

	public static void main(String[] args) throws Exception {

		testMultithreadJIoSocket();

	}

	public static void testMultithreadJIoSocket() throws Exception

	{

		ServerSocket serverSocket = new ServerSocket(10002);

		Thread thread = new Thread(new Accptor(serverSocket));

		thread.start();

		Scanner scanner = new Scanner(System.in);

		scanner.next();

	}
}