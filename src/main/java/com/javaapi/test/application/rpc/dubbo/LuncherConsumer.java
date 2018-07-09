package com.javaapi.test.application.rpc.dubbo;

import java.util.ArrayList;
import java.util.List;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * 
 * @see http://blog.csdn.net/ruishenh/article/details/23180707
 */
public class LuncherConsumer  {
	public static void main(String[] args) throws InterruptedException{
		LuncherConsumer luncher=new LuncherConsumer();
		luncher.start();
	}
	
	
	void start(){

//        String configLocation = LuncherConsumer.class.getResource("").getPath() + "dubbo-consumer.xml";
//        ApplicationContext context = new FileSystemXmlApplicationContext("file:" + configLocation);
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:" + "com/javaapi/test/application/rpc/dubbo/dubbo-consumer.xml");
		DemoService ds=(DemoService) context.getBean("demoService");
		String [] names=context.getBeanDefinitionNames();
		System.out.print("Beans:");
		for (String string : names) {
			System.out.println(string);
			System.out.println(",");
		}
		System.out.println();
		
		MsgInfo info =new MsgInfo();
		info.setId(1);
		info.setName("ruisheh");
		List<String> msgs=new ArrayList<String>();
		msgs.add("I");
		msgs.add("am");
		msgs.add("test");
		info.setMsgs(msgs);
		
		
		System.out.println(ds.returnMsgInfo(info).getMsgs());
        System.out.println("============");
        MyTestService mt = (MyTestService) context.getBean("myTestService");
        System.out.println(mt.sendMessage("kk"));
        System.out.println("============");

        DemoService demoService = (DemoService) context.getBean("demoService");
        demoService.returnMsgInfo2("winter",EnumSample.Winter);
        demoService.returnMsgInfo2("summer",EnumSample.Summer);
        demoService.returnMsgInfo2("autum",EnumSample.a2);

    }
}
