package com.javaapi.test.util.io.blockIo.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class Processor implements Runnable

{

	private Socket socket;

	public Processor(Socket socket)

	{

		this.socket = socket;

	}

	@Override
	public void run()

	{

		try

		{

			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String readLine;

			while (true)

			{

				readLine = in.readLine();

				System.out.println("收到消息" + readLine);

				if ("end".equals(readLine))

				{

					break;

				}

				// 客户端断开连接

				socket.sendUrgentData(0xFF);

				Thread.sleep(5000);

			}

		}

		catch (InterruptedException e)

		{

			e.printStackTrace();

		}

		catch (SocketException se)

		{

			System.out.println("客户端断开连接");

		}

		catch (IOException e)

		{

			e.printStackTrace();

		}

		finally {

			try

			{

				socket.close();

				System.out.println("socket 被关闭");

			}

			catch (IOException e)

			{

				e.printStackTrace();

			}

		}

	}

}
