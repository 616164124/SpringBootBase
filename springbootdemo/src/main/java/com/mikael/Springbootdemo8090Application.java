package com.mikael;

import io.netty.util.concurrent.CompleteFuture;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
@Slf4j
public class Springbootdemo8090Application {

    public static void main(String[] args) {
        log.info("jsif,{}", "hello");

        SpringApplication.run(Springbootdemo8090Application.class, args);
    }

}
