package com.javaapi.test.application.test.testmockito.mockitSpring;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.javaapi.test.application.test.testmockito.mockitSpring.po.RouteMatrix;

@RunWith(MockitoJUnitRunner.class)  
public class ClientMockito{  
	
   @InjectMocks  
   private IRouteService service = new RouteServiceImpl();
   
   @Mock  
   private IRouteMatrixDataProvider provider;

   private String	brand;

   private String	cInfo;  
  
  
   @Test  
   public void testGetAirlineCode() {
	   RouteMatrix value = new RouteMatrix();
	   value.setAirlineCode("kk_airCode");
	   when(provider.getRevenueRoute("HKG", "AMM", true)).thenReturn(value);
//	   verify(service).getAirlineCode("HKG", "AMM", this.brand, this.cInfo, true);
       String code = this.service.getAirlineCode("HKG", "AMM", this.brand, this.cInfo, true);  
       Assert.assertNotNull(code);  
       Assert.assertEquals("nihao", code);  
   }  
   
   
   @Test  
   public void testGetAirlineCode1() {
	   when(provider.getRevenueRoute(Matchers.anyString(), Matchers.anyString(), Matchers.anyBoolean())).thenReturn(Matchers.any(RouteMatrix.class));
	   provider.getRevenueRoute(cInfo, brand, false);
	   verify(provider).getRevenueRoute(Matchers.anyString(), Matchers.anyString(), Matchers.anyBoolean());
   }  
	/**
	 * 但是这里也有一个限制就是，如果有一个参数使用了any***()，则所有的参数都必需使用这种方式，不能像下面这样写
	 * Mockito.when(this.provider.getRevenueRoute(Matchers.anyString(),
	 * Matchers.anyString(), true))
	 */
	@Test  
   public void testGetAirlineCode2() {
	   RouteMatrix value = new RouteMatrix();
	   value.setAirlineCode("kk_airCode");
	   when(provider.getRevenueRoute(Matchers.anyString(), Matchers.anyString(), Matchers.anyBoolean())).thenReturn(value);
       String code = this.service.getAirlineCode("HKG", "AMM", this.brand, this.cInfo, true);  
       //调用之后才能用断言进行验证
       verify(provider).getRevenueRoute(Matchers.anyString(), Matchers.anyString(), Matchers.anyBoolean());
       Assert.assertNotNull(code);  
       Assert.assertEquals("nihao", code);  
   }  
}  
