package com.javaapi.test.buisness.dao.mybatis.usage.extable;

import com.javaapi.test.buisness.dao.mybatis.usage.extable.entity.BillKvExt;
import com.javaapi.test.buisness.dao.mybatis.usage.extable.mapper.BillExtMapper;
import com.javaapi.test.buisness.dao.mybatis.usage.extable.mapper.BillMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Transactional
public class ClientKvLine {


    @Autowired
    BillMapper billMapper;

    @Autowired
    BillExtMapper billExtMapper;


    /**
     * 测试扩展表
     */
    @Test
    public void testSaveExt() {
        BillKvExt billKvExt = new BillKvExt();
        billKvExt.setBillUserName("kk from username");
        saveExt(billKvExt);
    }

    private void saveExt(BillKvExt billKvExt) {
    }


    /**
     * 测试扩展表
     */
    @Test
    public void testSelectExt() {

    }


}
