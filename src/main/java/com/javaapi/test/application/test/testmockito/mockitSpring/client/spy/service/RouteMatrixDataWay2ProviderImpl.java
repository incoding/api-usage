package com.javaapi.test.application.test.testmockito.mockitSpring.client.spy.service;

import com.javaapi.test.application.test.testmockito.mockitSpring.dao.IRouteMatrixDataProvider;
import com.javaapi.test.application.test.testmockito.mockitSpring.po.RouteMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RouteMatrixDataWay2ProviderImpl implements IRouteMatrixDataProvider {

    @Autowired
    private IWeather iWeather;


    @Override
    public RouteMatrix getRevenueRoute(String string, String string2, boolean b) {
        System.err.println("getRevenueRoute method");
        RouteMatrix routeMatrix = new RouteMatrix();
        routeMatrix.setAirlineCode(string + "_" + iWeather.getWeather(string2) + iWeather.getTime(string2));
        return routeMatrix;
    }

}
