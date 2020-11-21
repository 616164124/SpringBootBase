package com.mikael.jwtapplication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class JwtapplicationApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testjwt() {
        //当前时间
        long l = System.currentTimeMillis();
        //过期时间
        long exp = l + 60 * 1000;

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("8888")
                //接受的用户
                .setSubject("Rose")
                //签发时间
                .setIssuedAt(new Date())
                //签发算法跟密钥
                .signWith(SignatureAlgorithm.HS256, "xxxx")
                //添加过期时间
                .setExpiration(new Date(exp))
                //自定义声明   claim(map类型)
                .claim("hfskh", "fjkshkf");

        //签发token
        String compact = jwtBuilder.compact();
        System.out.println(compact);
        System.out.println("==========================");
        //解密
        String[] split = compact.split("\\.");
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        //会乱码
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));


    }

    @Test
    public void testDecodeJWT() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODg4Iiwic3ViIjoiUm9zZSIsImlhdCI6MTYwMzk4MzkwMn0.lXPOfzPEiS9kp0GeK3rVN5H_w5MoDpWnF07OhHykpHQ";
        Claims claims = (Claims) Jwts.parser().setSigningKey("xxxx").parse(token).getBody();

        System.out.println(claims.getId());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getSubject());

    }

}
