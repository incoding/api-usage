package com.javaapi.test.spring.spring.feature.javaconfig.ImportAnnotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ CustomerConfig.class, SchedulerConfig.class })
public class AppConfig {

}