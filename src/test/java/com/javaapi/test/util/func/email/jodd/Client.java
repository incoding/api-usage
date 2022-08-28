package com.javaapi.test.util.func.email.jodd;

import jodd.mail.Email;
import org.junit.Test;

/**
 * Created by user on 18/1/28.
 */
public class Client {
    @Test
    public void test(){
        Email email = Email.create()
                .from("...@jodd.org")
                .to("...@jodd.org")
                .subject("Hello!")
                .textMessage("A plain text message...");

    }
}
