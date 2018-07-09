package com.javaapi.test.spring.zotherFeature.javaconfig.configurationAnnotataion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Piano piano() {
        Piano piano = new Piano();
        piano.setSound("hahhahaha");
        return piano;
    }

    @Bean(name = "counter")
    public Counter counter() {
        return new Counter(12, "Shake it Off");
    }

    /**
     * 内部类会自动加载
     */
    @Configuration
    public static class Desk{
        public Desk() {
        }

        @Bean
        public Piano desck() {
            Piano piano = new Piano();
            piano.setSound("desk");
            return piano;
        }

    }


}