package com.javaapi.test.application.test.testmockito.mockitSpring.client.spy.service;

import org.springframework.stereotype.Service;

/**
 * Created by user on 2019/9/2
 */
@Service
public class WeatherServiceImpl implements IWeather {

    @Override
    public String getWeather(String code) {
        return "_weather_" + code;
    }

    @Override
    public String getTime(String code) {
        return "_time_" + code;
    }
}
