package com.javaapi.test.buisness.dao.hibernate.biz.status;


import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

public class SelfSaveOrUpdateListener extends DefaultSaveOrUpdateEventListener
{
    private static final long serialVersionUID = 7496518453770213930L;

    /*监听保存或更新事件*/
    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event)
    {

        System.out.println("invoke!================");

        /*一定要调用父类提供的功能，不然就和继承接口一样了*/
        super.onSaveOrUpdate(event);
    }
}