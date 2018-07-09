package com.javaapi.test.application.jms.jmssample1.spring.p2p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SenderApp {
    public static void main(String[] args) throws IOException {
        MessageSender sender = getMessageSender();
        System.out.println("please input your message:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        while (!StringUtils.isEmpty(text)) {
            System.out.println(String.format("send message: %s", text));
            sender.send(text);
            text = br.readLine();
        }
    }

    public static MessageSender getMessageSender() {
        String path = "file:" + SenderApp.class.getResource("").getPath() + "springJMSConfiguration.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(path);
        return (MessageSender) context.getBean("messageSender");
    }
}