package com.javaapi.test.buisness.dao.mybatis.usage.extable;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.buisness.dao.mybatis.usage.extable.converter.BillConvertor;
import com.javaapi.test.buisness.dao.mybatis.usage.extable.entity.Bill;
import com.javaapi.test.buisness.dao.mybatis.usage.extable.entity.BillExt;
import com.javaapi.test.buisness.dao.mybatis.usage.extable.entity.KvLine;
import com.javaapi.test.buisness.dao.mybatis.usage.extable.mapper.BillExtMapper;
import com.javaapi.test.buisness.dao.mybatis.usage.extable.mapper.BillMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Transactional
public class Client {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    BillMapper billMapper;

    @Autowired
    BillExtMapper billExtMapper;


    /**
     * 测试扩展表
     */
    @Test
    public void testSelectExt() {
        long billid = 1L;
        Bill selectBill = sqlSessionTemplate.getMapper(BillMapper.class).selectByBill(billid);
        Assert.assertNotNull(selectBill);
        List<KvLine> extMap = sqlSessionTemplate.getMapper(BillExtMapper.class).selectByBill(billid);
        BillExt billExt = convert(extMap);
        System.out.println("JSON.toJSONString(billExt) = " + JSON.toJSONString(billExt));
        Assert.assertNotNull(billExt);
    }


    /**
     * 测试扩展表
     */
    @Test
    public void testSaveExt() {
        long billid = 1L;
        Bill selectBill = sqlSessionTemplate.getMapper(BillMapper.class).selectByBill(billid);
        Assert.assertNotNull(selectBill);
        List<KvLine> extMap = sqlSessionTemplate.getMapper(BillExtMapper.class).selectByBill(billid);
        BillExt billExt = convert(extMap);
        if (StringUtils.isBlank(billExt.getBillUserId())) {
            billExt.setBillUserName("1");
        }
        Assert.assertNotNull(billExt);
    }


    private BillExt convert(List<KvLine> extMap) {
        if (CollectionUtils.isEmpty(extMap)) {
            return new BillExt();
        }
        Map<String, String> collect = extMap.stream().collect(Collectors.toMap(KvLine::getKey, KvLine::getValue, (existing, replacement) -> replacement));
        return BillConvertor.INSTANCE.map2ext(collect);
    }
}
