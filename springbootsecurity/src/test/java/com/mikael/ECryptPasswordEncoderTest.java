/**
 * projectName: SpringBootBase   
 * fileName: ECryptPasswordEncoderTest.java  
 * packageName: com.mikael   
 * date: 2020-10-26
 * copyright(c) 2017-2020 xxx公司  
 */
package com.mikael;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @version: V1.0
 * @author: mikael
 * @className: ECryptPasswordEncoderTest
 * @packageName: com.mikael
 * @description: security 加密
 * @data: 2020-10-26
 **/

public class ECryptPasswordEncoderTest {
    @Test
    public void ECryptPasswordEncoderTest() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //$2a$10$iU5ye5b7idl8uWekVgEoEO3zt7xE4MIfjM4Hevgu4r2HWzlz06Ph6
        //加密 自己内部生成一个盐
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
        //比较密码
        boolean matches = bCryptPasswordEncoder.matches("123", encode);
        System.out.println(matches);
    }
}
