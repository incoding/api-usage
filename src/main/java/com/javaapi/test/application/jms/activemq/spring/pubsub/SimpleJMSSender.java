package com.javaapi.test.application.jms.activemq.spring.pubsub;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * http://nettm.iteye.com/blog/1828268</br>
 *
 */
public class SimpleJMSSender {  
	  
    public static void main(String[] args) {  
    	String path = "file:"+SimpleJMSSender.class.getResource("").getPath()+"applicationContext-send.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(path);  
        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("myJmsTemplate");  
        for (int i = 0; i < 10; i++) {  
            jmsTemplate.send(new MessageCreator() {  
                public Message createMessage(Session session) throws JMSException {  
                    TextMessage msg = session.createTextMessage();  
                    // 设置消息属性  
                    msg.setStringProperty("phrCode", "C001");  
                    // 设置消息内容  
                    msg.setText("Hello World!");  
                    return msg;  
                }  
            });  
        }  
        System.out.println("message send!");
    }  
}  