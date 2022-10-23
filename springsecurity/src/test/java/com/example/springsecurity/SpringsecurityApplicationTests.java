package com.example.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class SpringsecurityApplicationTests {

    @Resource
    private BCryptPasswordEncoder bc;



    @Test
    void contextLoads() {
        String encode = bc.encode("123");
        System.out.println(
                encode
        );

    }

}
