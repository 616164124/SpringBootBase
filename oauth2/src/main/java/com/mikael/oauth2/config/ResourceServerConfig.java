/*
 * projectName: SpringBootBase
 * fileName: ResourceServerConfig.java
 * packageName: com.mikael.oauth2.config
 * date: 2020-10-29
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/*
 * @version: V1.0
 * @author: mikael
 * @className: ResourceServerConfig
 * @packageName: com.mikael.oauth2.config
 * @description:  资源服务器
 * @data: 2020-10-29
 **/
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/user/**").permitAll().anyRequest().authenticated();
    }
}
