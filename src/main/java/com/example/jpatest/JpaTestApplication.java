package com.example.jpatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JpaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaTestApplication.class, args);
    }

}
