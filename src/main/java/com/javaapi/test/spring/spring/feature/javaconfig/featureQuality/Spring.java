package com.javaapi.test.spring.spring.feature.javaconfig.featureQuality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static com.javaapi.test.spring.spring.feature.javaconfig.featureQuality.Spring.Platform;

/**
 * Created by user on 17/10/27.
 * Qualifier 可以标注注解,使之建立注入与被注入的关系
 * https://spring.io/blog/2014/11/04/a-quality-qualifier
 *
 */

@Configuration
@ComponentScan
public class Spring {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Spring.class);
    }

    @Autowired
    @Platform(Platform.OperatingSystems.ANDROID)
    private MarketPlace android;

    @Autowired
    @Platform(Platform.OperatingSystems.IOS)
    private MarketPlace ios;

    @PostConstruct
    public void qualifyTheTweets() {
        System.out.println("ios:" + this.ios);
        System.out.println("android:" + this.android);
    }

    // the type has to be public!
    @Target({ElementType.FIELD,
            ElementType.METHOD,
            ElementType.TYPE,
            ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Qualifier
    public static @interface Platform {

        OperatingSystems value();

        public static enum OperatingSystems {
            IOS,
            ANDROID
        }
    }
}

interface MarketPlace {
}

@Component
@Platform(Platform.OperatingSystems.IOS)
class AppleMarketPlace implements MarketPlace {

    @Override
    public String toString() {
        return "apple";
    }
}

@Component
@Platform(Platform.OperatingSystems.ANDROID)
class GoogleMarketPlace implements MarketPlace {

    @Override
    public String toString() {
        return "android";
    }
}
