package com.mikael;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class Springbootdemo8090Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootdemo8090Application.class, args);
    }

}
