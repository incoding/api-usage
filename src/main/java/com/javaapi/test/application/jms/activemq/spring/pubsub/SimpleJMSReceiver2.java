package com.javaapi.test.application.jms.activemq.spring.pubsub;

import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.JmsException;

public class SimpleJMSReceiver2 {  
	  
    public static void main(String[] args) {  
    	String path = "file:"+SimpleJMSReceiver2.class.getResource("").getPath()+"applicationContext-receive2.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(path);  
        try {
			TimeUnit.HOURS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }  
      
    public void receive(TextMessage message) throws JmsException, JMSException {  
        System.out.println(message.getStringProperty("phrCode"));  
        System.out.println(message.getText());  
    }  
}  