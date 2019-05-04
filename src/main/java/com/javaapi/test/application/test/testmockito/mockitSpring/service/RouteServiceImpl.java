package com.javaapi.test.application.test.testmockito.mockitSpring.service;

import com.javaapi.test.application.test.testmockito.mockitSpring.dao.IRouteMatrixDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaapi.test.application.test.testmockito.mockitSpring.po.RouteMatrix;

@Service
public class RouteServiceImpl implements IRouteService {
	@Autowired
	private IRouteMatrixDataProvider provider;
	@Override
	public String getAirlineCode(String string, String string2, Object brand,
			Object cInfo, boolean b) {
		System.err.println("getAirlineCode method");
		RouteMatrix revenueRoute = provider.getRevenueRoute(string, string2, b);
		System.err.println(revenueRoute);
		return "nihao";
	}

}
