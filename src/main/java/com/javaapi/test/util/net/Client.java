package com.javaapi.test.util.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by user on 16/3/7.
 */
public class Client {
    @Test
    public void test() throws UnknownHostException {
        byte[] address = InetAddress.getLocalHost().getAddress();
        for (byte addres : address) {
            System.out.println(addres);
        }
    }
}
