package com.javaapi.test.application.jms.rabbitmq.primitive.tutorial;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

//  发送接收
public class Send {

    private final static String QUEUE_NAME = "hello";
//    public static final String HOST = "192.168.60.25";
    public static final String HOST = "localhost";


    public static void main(String[] argv) throws Exception {
        // 以下代码简便发送,可否用于生产环境有待研究
        for (int i = 0; i < 1; i++) {

            argv = new String[]{"info"};

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(HOST);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!="+i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");

            channel.close();
            connection.close();
        }
    }
}