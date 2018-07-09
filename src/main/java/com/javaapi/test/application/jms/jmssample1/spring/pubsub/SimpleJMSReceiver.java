package com.javaapi.test.application.jms.jmssample1.spring.pubsub;

import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.JmsException;

public class SimpleJMSReceiver {  
	  
    public static void main(String[] args) {  
    	String path = "file:"+SimpleJMSReceiver.class.getResource("").getPath()+"applicationContext-receive.xml";
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