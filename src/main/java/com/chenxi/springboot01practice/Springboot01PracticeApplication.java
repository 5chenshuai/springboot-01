package com.chenxi.springboot01practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.chenxi.springboot01practice.mapper.StuMapper")
@SpringBootApplication
public class Springboot01PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01PracticeApplication.class, args);
    }

}
