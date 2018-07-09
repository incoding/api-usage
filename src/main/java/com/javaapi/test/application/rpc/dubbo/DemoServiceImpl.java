package com.javaapi.test.application.rpc.dubbo;

public class DemoServiceImpl implements DemoService{
	
	public void sayHello() {
		System.out.println("hello world!");
	}

	public String returnHello() {
		return "hello world!";
	}

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