package com.javaapi.test.application.test.testmockito.mockitSpring.client.spy.service;

import com.javaapi.test.application.test.testmockito.mockitSpring.dao.IRouteMatrixDataProvider;
import com.javaapi.test.application.test.testmockito.mockitSpring.po.RouteMatrix;
import com.javaapi.test.application.test.testmockito.mockitSpring.service.IRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RouteWay2ServiceImpl implements IRouteService {

    @Resource(name = "routeMatrixDataWay2ProviderImpl")
    private IRouteMatrixDataProvider provider;

    @Override
    public String getAirlineCode(String string, String string2, Object brand,
                                 Object cInfo, boolean b) {
        System.err.println("getAirlineCode method");
        RouteMatrix revenueRoute = provider.getRevenueRoute(string, string2, b);
        return revenueRoute.getAirlineCode();
    }

}
