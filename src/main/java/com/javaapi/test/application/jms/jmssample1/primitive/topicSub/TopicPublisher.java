package com.javaapi.test.application.jms.jmssample1.primitive.topicSub;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicPublisher {  
    private static int	SEND_NUMBER = 5;
	public static void main(String[] args) throws JMSException {  
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");  
        Connection connection = factory.createConnection();  
        connection.start();  
          
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);  
        Topic topic = session.createTopic("myTopic.messages");
  
        MessageProducer producer = session.createProducer(topic);  
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);  
        try {
			sendMessage(session, producer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        while(true) {  
//            TextMessage message = session.createTextMessage();  
//            message.setText("message_" + System.currentTimeMillis());  
//            producer.send(message);  
//            System.out.println("Sent message: " + message.getText());  
//  
//            try {  
//                Thread.sleep(1000);  
//            } catch (InterruptedException e) {  
//                e.printStackTrace();  
//            }  
//            session.commit();
//        }  
      session.commit();
      session.close();  
      connection.stop();  
      connection.close();  
    }  
    public static void sendMessage(Session session, MessageProducer producer) throws Exception {
        for (int i = 1; i <= SEND_NUMBER ; i++) {
            TextMessage message = session.createTextMessage("ActiveMq 发送的消息" + i);
            // 发送消息到目的地方
            System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
            producer.send(message);
        }
    }
}  