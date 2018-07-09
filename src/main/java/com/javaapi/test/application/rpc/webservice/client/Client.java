package com.javaapi.test.application.rpc.webservice.client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * https://www.cnblogs.com/linxiaoyang/p/4167016.html
 */
public class Client {
    public static void main(String args[]) {
        HelloWorldImplService helloWorldImplService = new HelloWorldImplService();
        HelloWorldImpl helloWorld = helloWorldImplService.getHelloWorldImplPort();
        HelloReq helloReq = new HelloReq();
        helloReq.setReq("你好");
        HelloResp returnStr = helloWorld.sayHello(helloReq);
        String request = convertToXml(helloReq);
        System.out.println("s = " + request);
//        String response = convertToXml(returnStr);
//        System.out.println("response = " + response);

        System.out.println(returnStr.getResp());
    }


    /**
     * 将对象直接转换成String类型的 XML输出
     *
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
//            JAXBElement jaxbElement = new JAXBElement(new QName("root-element"), obj.getClass(), obj);
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }


}