package com.javaapi.test.application.jms.rabbitmq.primitive.tutorial;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Recv {

//    public static final String HOST = "192.168.60.25";
    public static final String HOST = "localhost";
    private final static String QUEUE_NAME = "hello";

    @Test
    public void testAutoAck() throws IOException {
        String [] argv = new String[]{"info"};

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
//                if(true) {
//                    throw new RuntimeException("模拟异常");
//                }
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testNoAutoAck() throws Exception {
        String [] argv = new String[]{"info"};

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                    String message = new String(body, "UTF-8");
//                    if(true) {
//                        throw new RuntimeException("模拟异常");
//                    }
                    System.out.println(" [x] Received '" + message + "'");
                    this.getChannel().basicAck(envelope.getDeliveryTag(), false);
//                finally {
//                    this.getChannel().basicAck(envelope.getDeliveryTag(), false);
//                }
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}