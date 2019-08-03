package com.javaapi.test.buisness.dao.hibernate.biz.status;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

/**
 * Created by user on 16/1/18.
 */
public class SelfListener implements SaveOrUpdateEventListener {
    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
        System.out.println("event = " + event.getEntityName());
        System.out.println("event = " + event.getResultId());
    }
}
