package com.javaapi.test.application.test.testmockito.mockitSpring.client.spy;

import com.javaapi.test.application.test.testmockito.mockitSpring.dao.IRouteMatrixDataProvider;
import com.javaapi.test.application.test.testmockito.mockitSpring.service.IRouteService;
import com.javaapi.test.application.test.testmockito.mockitSpring.client.spy.service.IWeather;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * 参考 https://blog.csdn.net/z199172177/article/details/79731952
 * <p>
 * IRouteService 中
 * IWeather 使用 真实spring bean
 * IRouteMatrixDataProvider 由于使用了py和Autowired 注解 所以使用mock
 * <p>
 * <p>
 * https://blog.csdn.net/Aeroleo/article/details/49946999?locationNum=14&fps=1
 * 通过spy做的桩实现仍然会调用实际方法，但返回的是你mock要求的返回。
 * ★ 批注：spy方法需要使用doReturn方法才不会调用实际方法。
 * <p>
 * https://blog.csdn.net/hotdust/article/details/51416894
 * doReturn("twotwo").when(ps).getPriceTwo();
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class ClientSpy {

    @InjectMocks
    @Resource(name = "routeWay2ServiceImpl")
    private IRouteService service;

    @InjectMocks
    @Resource(name = "routeMatrixDataWay2ProviderImpl")
    private IRouteMatrixDataProvider provider;

    @Spy
    @Autowired
    private IWeather iWeather;

    private String brand;

    private String cInfo;


    @Before
    public void myBefore() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * spy 默认行为是会调用真实方法,但是返回是mock数据
     */
    @Test
    public void testSpy() {
        when(iWeather.getWeather("AMM")).thenReturn("spy_city");
        String code = this.service.getAirlineCode("HKG", "AMM", this.brand, this.cInfo, true);
        System.out.println("code = " + code);
    }

    /**
     * spy 通过doreturn 方式不会调用真实方式,  并且可以返回mock数据
     */
    @Test
    public void testDoReturnSpy() {
        doReturn("spy_city").when(iWeather).getWeather("AMM");
        String code = this.service.getAirlineCode("HKG", "AMM", this.brand, this.cInfo, true);
        System.out.println("code = " + code);
    }


    /**
     * spy 通过doreturn 方式不会调用真实方式,  并且可以返回mock数据
     */
    @Test
    public void testSpyAnyString() {
        doReturn("spy_city").when(iWeather).getWeather(Matchers.anyString());
        String code = this.service.getAirlineCode("HKG", "AMM", this.brand, this.cInfo, true);
        System.out.println("code = " + code);
    }

    /**
     * 这个是指定调用真实实现
     */
    @Test
    public void testDoCallRealMethod() {
        Mockito.doCallRealMethod().when(iWeather).getWeather("AMM");
        String code = this.service.getAirlineCode("HKG", "AMM", this.brand, this.cInfo, true);
        System.out.println("code = " + code);
    }


}  
