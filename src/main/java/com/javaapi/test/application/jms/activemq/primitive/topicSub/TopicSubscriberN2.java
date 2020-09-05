package com.javaapi.test.application.jms.activemq.primitive.topicSub;

import java.util.concurrent.TimeUnit;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicSubscriberN2 {  
    public static void main(String[] args) throws JMSException {  
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");  
        Connection connection = factory.createConnection();  
        //持久订阅 需要设置  clientid
        connection.setClientID("subscriber2");
        connection.start();  
          
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);  
        Topic topic = session.createTopic("myTopic.messages");  
  
//        MessageConsumer consumer = session.createConsumer(topic);  
        TopicSubscriber  consumer = session.createDurableSubscriber(topic, "subscriber2");
        consumer.setMessageListener(new MessageListener() {  
            public void onMessage(Message message) {  
                TextMessage tm = (TextMessage) message;  
                try {  
                    System.out.println("Received message from n2: " + tm.getText());  
                } catch (JMSException e) {  
                    e.printStackTrace();  
                }  
            }  
        });  
        try {
			TimeUnit.HOURS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
      session.close();  
      connection.stop();  
      connection.close();  
    }  
}  