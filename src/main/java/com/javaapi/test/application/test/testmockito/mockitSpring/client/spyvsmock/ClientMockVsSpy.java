package com.javaapi.test.application.test.testmockito.mockitSpring.client.spyvsmock;

import com.javaapi.test.application.test.testmockito.mockitSpring.client.spy.service.IWeather;
import com.javaapi.test.application.test.testmockito.mockitSpring.dao.IRouteMatrixDataProvider;
import com.javaapi.test.application.test.testmockito.mockitSpring.service.IRouteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;

/**
 * 参考 https://blog.csdn.net/z199172177/article/details/79731952
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class ClientMockVsSpy {
    @InjectMocks
    @Resource(name = "routeWay2ServiceImpl")
    private IRouteService service;

    @InjectMocks
    @Resource(name = "routeMatrixDataWay2ProviderImpl")
    private IRouteMatrixDataProvider provider;

    @Mock
    @Autowired
    private IWeather iWeather;

    private String brand;

    private String cInfo;


    @Before
    public void myBefore() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        when(iWeather.getWeather("AMM")).thenReturn("spy_city");
        String code = this.service.getAirlineCode("HKG", "AMM", this.brand, this.cInfo, true);
        System.out.println("code = " + code);
    }


}  
