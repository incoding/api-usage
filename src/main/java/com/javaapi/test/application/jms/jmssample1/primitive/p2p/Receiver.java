package com.javaapi.test.application.jms.jmssample1.primitive.p2p;

import java.util.concurrent.TimeUnit;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver {
    public static void main(String[] args) {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // 消费者，消息接收者
        MessageConsumer consumer;
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
            destination = session.createQueue("FirstQueue2");
            consumer = session.createConsumer(destination);
//            getMsgByListener(consumer);  
            
            getMsgWayOne(consumer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
        }
    }

	/** 异步消费。客户可以为消费者注册一个消息监听器，以定义在消息到达时所采取的动作。 
	 * @param consumer
	 * @throws JMSException
	 */
	private static void getMsgByListener(MessageConsumer consumer)
			throws JMSException {
		consumer.setMessageListener(new MessageListener() {  
		    public void onMessage(Message message) {  
		        TextMessage tm = (TextMessage) message;  
		        try {  
		            System.out.println("Received message: " + tm.getText());  
		        } catch (JMSException e) {  
		            e.printStackTrace();  
		        }  
		    }  
		});
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**同步消费。通过调用消费者的receive方法从目的地中显式提取消息。receive方法可以一直阻塞到消息到达。
	 * @param consumer
	 * @throws JMSException
	 */
	private static void getMsgWayOne(MessageConsumer consumer)
			throws JMSException {
		while (true) {
		    //设置接收者接收消息的时间，为了便于测试，这里谁定为100s
		    TextMessage message = (TextMessage) consumer.receive(100000);
		    if (null != message) {
		        System.out.println("收到消息" + message.getText());
		    } else {
		        break;
		    }
		}
	}
}