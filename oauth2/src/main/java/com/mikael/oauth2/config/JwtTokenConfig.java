package com.mikael.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @version: V1.0
 * @author: mikael
 * @className: JwtConfig
 * @packageName: com.mikael.oauth2.config
 * @description:
 * @data: 2020-12-04
 **/
@Configuration
public class JwtTokenConfig {

    @Bean
    public TokenStore jwtToken() {
        return new JwtTokenStore(new JwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        //设置密钥
        tokenConverter.setSigningKey("testkey");
        return tokenConverter;
    }
}
