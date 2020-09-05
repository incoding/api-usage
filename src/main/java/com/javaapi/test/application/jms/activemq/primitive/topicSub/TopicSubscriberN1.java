package com.javaapi.test.application.jms.activemq.primitive.topicSub;

import java.util.concurrent.TimeUnit;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 订阅,和持久化订阅</br>
 * 单凭Client Id还不足以唯一标志某一个Durable Subscription，就跟我凭一个身份证，可以预定多个房间一样。 同一个连接里，你可以创建多个MessageConsumer去订阅不同Topic的消息，如果下回回来，你只想继续接受某一个Topic消息的话，JMS Provider如何知道是哪一个？ 所以，为了区分同一个Connection中不同的Durable Subscription，我们还需要进一步的标志物，这就是Subscriber Name！ 
 *
 */
public class TopicSubscriberN1 {  
    public static void main(String[] args) throws JMSException {  
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");  
        Connection connection = factory.createConnection();  
        //持久订阅 需要设置  clientid
        connection.setClientID("subscriber1");
        connection.start();  
          
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);  
        Topic topic = session.createTopic("myTopic.messages");  
  
//        MessageConsumer consumer = session.createConsumer(topic);  
        TopicSubscriber  consumer = session.createDurableSubscriber(topic,"subscriber1"); //持久订阅
//        getMsgWayOne(consumer);
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
			TimeUnit.HOURS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      session.close();  
      connection.stop();  
      connection.close();  
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