package com.javaapi.test.application.test.testmockito.mockitSpring;

import com.javaapi.test.application.test.testmockito.mockitSpring.dao.IRouteMatrixDataProvider;
import com.javaapi.test.application.test.testmockito.mockitSpring.service.IRouteService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO spy注解
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class ClientSpy {
    @InjectMocks
    @Autowired
    private IRouteService service;

    @Mock
    private IRouteMatrixDataProvider provider;

    @Before
    public void myBefore() {
        MockitoAnnotations.initMocks(this);
    }


}  
