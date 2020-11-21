/*
 * projectName: SpringBootBase
 * fileName: AuthorzationServerConfig.java
 * packageName: com.mikael.oauth2.config
 * date: 2020-10-29
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

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

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().
                withClient("client")  //客户端
                .secret(passwordEncoder.encode("112233"))    //密钥
                .redirectUris()   //重定向
                .scopes("all")  //授权范围
                .authorizedGrantTypes("authorization_code");    //授权类型    授权码模式
    }
}
