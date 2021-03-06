/*
 * projectName: SpringBootBase
 * fileName: AuthorzationServerConfig.java
 * packageName: com.mikael.oauth2.config
 * date: 2020-10-29
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;

/*
 * @version: V1.0
 * @author: mikael
 * @className: AuthorzationServerConfig
 * @packageName: com.mikael.oauth2.config
 * @description: 授权服务器
 * @data: 2020-10-29
 **/
@EnableAuthorizationServer
@Configuration
public class AuthorzationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private JwtTokenStore jwtTokenStore;
    @Resource
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().
                withClient("client")  //客户端
                .secret(passwordEncoder.encode("112233"))    //密钥
                .redirectUris()   //重定向
                .scopes("all")  //授权范围
                //失效时间
                .accessTokenValiditySeconds(10)
                //刷新令牌过期时间
                .refreshTokenValiditySeconds(42000)

                .authorizedGrantTypes("authorization_code", "password", "refresh_token");    //授权类型    授权码模式

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                //将accessToken转成 jwttoken
                .tokenStore(jwtTokenStore)
                .accessTokenConverter(jwtAccessTokenConverter);

    }

}
