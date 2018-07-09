package com.javaapi.test.testUtil.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO客户端 有点问题
 */
public class NIOClient {

	private Selector selector;

	/**
	 * 获得一个Socket通道，并对该通道做一些初始化的工作
	 * 
	 * @param ip连接的服务器的ip
	 * @param port连接的服务器的端口号
	 * @throws IOException
	 */
	public void initClient(String ip, int port) throws IOException {
		selector = Selector.open();

		// 获得一个Socket通道，并设置为非阻塞
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);

		// 客户端连接服务器,其实方法执行并没有实现连接，需要在listen()方法中调
		// 用channel.finishConnect();才能完成连接
		channel.connect(new InetSocketAddress(ip, port));

		// 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
		channel.register(selector, SelectionKey.OP_CONNECT);
	}

	/**
	 * 循环监听selector上是否有需要处理的事件，如果有，则进行处理
	 * 
	 * @throws IOException
	 */
	public void listen() throws IOException {
		// 循环访问selector
		while (true) {
			// //当注册的事件到达时，方法返回；否则,该方法会一直阻塞
			selector.select();

			// 返回发生了事件的SelectionKey对象的一个 集合
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = selectedKeys.iterator();

			while (it.hasNext()) {
				SelectionKey key = (SelectionKey) it.next();

				it.remove(); // 删除已选的key以防重复处理

				// 连接事件发生
				if ((key.readyOps() & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT) {
					// 获得和服务器连接的通道
					SocketChannel channel = (SocketChannel) key.channel();

					// 如果正在连接，则完成连接
					if (channel.isConnectionPending()) {
						channel.finishConnect();
					}

					channel.configureBlocking(false);// 设置成非阻塞
					// 在和服务器连接成功之后，为了可以向服务器发送信息，需要为通道注册写事件。
					channel.register(this.selector, SelectionKey.OP_WRITE);
				} else if ((key.readyOps() & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE) {
					// 得到可写事件发生的Socket通道
					SocketChannel channel = (SocketChannel) key.channel();

					String msg = new String("Hello, Nice to meet you!");
					channel.write(ByteBuffer.wrap(msg.getBytes())); // 向服务器发送信息

					// 在向服务器写完信息之后，为了可以接收到服务器返回的信息，需要给通道注册读事件。
					channel.register(this.selector, SelectionKey.OP_READ);

					System.out.println("客户端发送信息：" + msg);
				} else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
					// 得到可读事件发生的Socket通道
					SocketChannel channel = (SocketChannel) key.channel();

					ByteBuffer echoBuffer = ByteBuffer.allocate(1024);

					while (true) {
						echoBuffer.clear();
						int r = channel.read(echoBuffer);

						// 判断拷贝是否完成
						if (r <= 0) {
							break;
						}
					}

					byte[] data = echoBuffer.array();
					System.out.println("客户端收到信息：" + new String(data).trim());
				}
			}
		}
	}

	/**
	 * 启动客户端测试
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		NIOClient client = new NIOClient();
		client.initClient("localhost", 10002);
		client.listen();
	}

}
