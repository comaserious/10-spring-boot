package com.ohgiraffers.autoconfiguration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan("com.ohgiraffers.autoconfiguration")
// 이런식으로 Application 과 같은 패키지 내에 configuration 클래스를 생성하고
// 해당 configuration 클래스를 componentScan 을 원하는 범위로 넓히면
// 원하는대로 bean 을 생성할 수 있다
public class SpringConfiguration {

    // @Propertysoucre 없이도 자동으로 application.properties 파일과 연결 시켜준다

    @Value("${test.value}")
    private String value;

    @Value("${test.list}")
    private String[] list;

    @Value("${test.greeting}")
    private String greeting;
    @Value("${test.array}")
    private String[] array;

    @Value("${username}")
    private String username;

    @Bean
    public Object propertyReadTest(){
        System.out.println("value = " + value);


//        System.out.println("list = " + list);
        Arrays.stream(list).forEach(System.out::println);

        System.out.println("greeting = " + greeting);

        Arrays.stream(array).forEach(System.out::println);

        System.out.println("username = " + username);
        return new Object();

    }




}
