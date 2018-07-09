package com.javaapi.test.buisness.exception.exceptionusage.exceptionmsg;

import org.junit.Test;

import java.net.ConnectException;

/**
 * https://stackoverflow.com/questions/8613408/exception-message-is-null
 * The message and the stacktrace are two distinct pieces of information. While the stackstrace is mandatory, the message is not. Most exceptions carry a message, and it is the best practice to do so, but some just don't and there's nothing to be done to fix it.
 * <p>
 * You can make it easier for your clients though and provide a message by wrapping the message-less exception or throwing a custom exception with the original exception as the cause. This might look like following.
 *
 * e.getMessage() 不是必须有值的
 */
public class Client {
    @Test
    public void test() {
        Boolean bool = null;
        try {
            bool.toString();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Test
    public void test2() {
        try {
            throw new ConnectException();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
