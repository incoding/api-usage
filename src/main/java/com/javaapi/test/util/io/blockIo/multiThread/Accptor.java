package com.javaapi.test.util.io.blockIo.multiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Accptor implements Runnable

{

	private ServerSocket serverSocket;

	public Accptor(ServerSocket serverSocket)

	{

		this.serverSocket = serverSocket;

	}

	public void run()

	{

		while (true)

		{

			Socket socket = null;

			try

			{

				socket = serverSocket.accept();

				if (socket != null)

				{

					System.out.println("收到了socket："
							+ socket.getRemoteSocketAddress().toString());

					Thread thread = new Thread(new Processor(socket));

					thread.start();

				}

			}

			catch (IOException e)

			{

				e.printStackTrace();

			}

		}

	}

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(10002);
			new Accptor(serverSocket).run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}