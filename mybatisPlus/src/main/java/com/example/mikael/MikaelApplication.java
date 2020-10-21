package com.example.mikael;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mikael.dao")
public class MikaelApplication {

  public static void main(String[] args) {
    SpringApplication.run(MikaelApplication.class, args);
  }
}
