package com.javaapi.test.testUtil.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 时间处理isacceptable 未处理 Channel,Buffer,Charset
 * 
 * @author hncw
 * 
 */
public class TestServer {
	public static Selector selector;
	static {
		try {
			selector = Selector.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerSocketChannel serverSocketChannel;
		try {
			// 必须调用open才可以创建 ServerSocketChannel实例，然后对实例进行配置
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.bind(new InetSocketAddress("localhost", 10002));
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				selector.select();
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey sk = it.next();
					it.remove();
					handle(sk);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void handle(SelectionKey selectionKey) {
		ByteBuffer dst = ByteBuffer.allocate(1024);
		if (selectionKey.isAcceptable()) {
			try {
				ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey
						.channel();
				// serverSocketChannel.accept(); 这个得用法
				SocketChannel socketChannel = serverSocketChannel.accept();
				socketChannel.configureBlocking(false);
				socketChannel.register(selector, SelectionKey.OP_READ);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		if (selectionKey.isReadable()) {
			try {
				SocketChannel socketChannel = (SocketChannel) selectionKey
						.channel();
				dst.clear();
				socketChannel.read(dst);
				System.out.println("服务端收到得信息==>"
						+ new String(dst.array(), "utf-8"));
				dst.flip();
				// 俩种操作都可以
				socketChannel.register(selector, SelectionKey.OP_WRITE);
				// selectionKey.interestOps(SelectionKey.OP_WRITE);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (selectionKey.isWritable()) {
			ByteBuffer cb = ByteBuffer.allocate(1024);
			SocketChannel socketChannel = (SocketChannel) selectionKey
					.channel();
			String repInfo = "这是来自服务器得消息";
			cb.put(repInfo.getBytes());
			cb.flip();
			try {
				socketChannel.write(cb);
				socketChannel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
