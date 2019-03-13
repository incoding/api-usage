package com.javaapi.test.application.rpc.dubbo.facadeImpl;

import com.javaapi.test.application.rpc.dubbo.facade.DemoService;
import com.javaapi.test.application.rpc.dubbo.model.EnumSample;
import com.javaapi.test.application.rpc.dubbo.model.MsgInfo;

public class DemoServiceImpl implements DemoService {
	
	@Override
	public void sayHello() {
		System.out.println("hello world!");
	}

	@Override
	public String returnHello() {
		return "hello world!";
	}

	@Override
	public MsgInfo returnMsgInfo(MsgInfo info) {
		info.getMsgs().add("处理完毕");
		return info;
	}

    /**
     * 传入了一个  服务端没有的枚举参数,会抛堆栈,相应枚举参数设置为空,然后程序正常执行
     * 比如:returnMsgInfo2 method
            name is :null
     * @param info
     * @return
     */
    @Override
    public MsgInfo returnMsgInfo2(String name,EnumSample info) {
        System.out.println("returnMsgInfo2 method:"+name);
        System.out.println("name is :"+info);
        return null;
    }
}