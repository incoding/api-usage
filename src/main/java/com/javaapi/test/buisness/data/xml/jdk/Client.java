package com.javaapi.test.buisness.data.xml.jdk;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 参考
 * http://www.oschina.net/code/snippet_12_5581
 */
public class Client {
    @Test
    public void testMarshal() throws JAXBException {
        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("mkyong");
        customer.setAge(29);

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter writer = new StringWriter();
            jaxbMarshaller.marshal(customer, writer);
            String xmlStr = writer.toString();
            System.out.println("writer.toString() = " + xmlStr);
            System.out.println("------------");
            unMar(xmlStr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }


    private void unMar(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StringReader stringReader = new StringReader(xml);
        Customer customer = (Customer) jaxbUnmarshaller.unmarshal(stringReader);
        System.out.println(customer);
    }
}
