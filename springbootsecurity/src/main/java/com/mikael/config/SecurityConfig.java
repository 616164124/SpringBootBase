package com.mikael.config;

import com.mikael.handle.MyAccessDeniedHandler;
import com.mikael.handle.MyForwardAuthenticationFailureHandler;
import com.mikael.handle.MyForwardAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @version: V1.0
 * @author: mikael
 * @className: SecurityConfig
 * @packageName: com.mikael.config
 * @description:
 * @data: 2020-10-26
 **/
@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin()
                //自定义登录页面
                .loginPage("/showLogin")
                //必须和页面表单接口提交的一样,会去执行自定义逻辑
                .loginProcessingUrl("/login")
                //登录成功后跳转页面  只接受post请求
                //  .successForwardUrl("/toSuccess")
                //自定义跳转页面
                .successHandler(new MyForwardAuthenticationSuccessHandler("/success.html"))
                //登录失败跳转页面
                // .failureForwardUrl("/toError");
                //自定义失败页面
                .failureHandler(new MyForwardAuthenticationFailureHandler("/error.html"));

        // 异常处理
        http.exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler());
        //授权   有基于角色 权限 ip 来授权  可以根据access来授权详情看官网
        http.authorizeRequests()
                //满足条件放行，不需要认证
                .antMatchers("/showLogin.html").permitAll()
                .antMatchers("/error.html").permitAll()
                //所有请求必须认证才能访问，即必须先登录成功
                .anyRequest().authenticated();

        //退出
        http.logout().logoutSuccessUrl("/login.html");

        //关闭csrf
        // http.csrf().disable();
    }


}

