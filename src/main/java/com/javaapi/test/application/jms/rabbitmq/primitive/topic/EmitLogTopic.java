package com.javaapi.test.application.jms.rabbitmq.primitive.topic;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class EmitLogTopic {

  private static final String EXCHANGE_NAME = "topic_logs";
//    public static final String HOST = "192.168.60.25";
    public static final String HOST = "localhost";
    public static int index=0;


    public static void main(String[] argv) {
        for (int i = 0; i < 3; i++) {
            index = i;
            argv = new String[]{"info"};

            Connection connection = null;
            Channel channel = null;
            try {
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost(HOST);

                connection = factory.newConnection();
                channel = connection.createChannel();

                channel.exchangeDeclare(EXCHANGE_NAME, "topic");

                String routingKey = getRouting(argv);
                String message = getMessage(argv);

                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception ignore) {
                    }
                }
            }
        }
  }

  private static String getRouting(String[] strings){
    if (strings.length < 1)
    	    return "anonymous.info";
    return strings[0];
  }

  private static String getMessage(String[] strings){
    if (strings.length < 2)
    	    return "Hello World!="+index;
    return joinStrings(strings, " ", 1);
  }

  private static String joinStrings(String[] strings, String delimiter, int startIndex) {
    int length = strings.length;
    if (length == 0 ) return "";
    if (length < startIndex ) return "";
    StringBuilder words = new StringBuilder(strings[startIndex]);
    for (int i = startIndex + 1; i < length; i++) {
        words.append(delimiter).append(strings[i]);
    }
    return words.toString();
  }
}

