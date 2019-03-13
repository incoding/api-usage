package com.javaapi.test.application.rpc.dubbo;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;


public class LuncherProvider  {
	public static void main(String[] args) throws InterruptedException{
		LuncherProvider luncher=new LuncherProvider();
		luncher.start();
		Thread.sleep(1000*60*10);
	}
	
	void start() {
//        String configLocation = LuncherProvider.class.getResource("").getPath() + "dubbo-provider.xml";
//        String configLocation = LuncherProvider.class.getClassLoader().getResource("com/javaapi/test/application/rpc/dubbo/dubbo-provider.xml").getPath();
//        System.out.println(configLocation);
//        ApplicationContext context = new FileSystemXmlApplicationContext("file:" + configLocation);
//        System.out.println("path is:" + configLocation);
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:" + "com/javaapi/test/application/rpc/dubbo/facadeImpl/dubbo-provider.xml");
        String[] names = context.getBeanDefinitionNames();
        System.out.print("Beans:");
        for (String string : names) {
            System.out.println(string);
            System.out.println(",");
        }
        System.out.println("=============end===========");
    }
}
