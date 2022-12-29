package com.example.springsecurity.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * springsecurity 配置类
 */
@Configuration
public class SecuriytConfig extends WebSecurityConfigurerAdapter {

    /**
     * 跟UserDetailsServieImpl中的要一致
     * 选择的加密解密器
     *
     * @return new Pbkdf2PasswordEncoder("123")
     */
    @Bean
    public Pbkdf2PasswordEncoder getpwd() {
        return new Pbkdf2PasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                //username跟password要跟页面提交的一致
//                .usernameParameter("username").passwordParameter("password")
                //当发现/login时认为是登录，必须和表单提交的地址一样，去执行userdetailServiceImpl
                .loginProcessingUrl("/login")
                .loginPage("/login.html")
                //登录成功后跳转页面，post请求
                .successForwardUrl("/main")
                //登录失败后跳转的页面
                .failureForwardUrl("/error404")
        ;

        //授权认证
        http.authorizeRequests()
                //满足不需要被认证 这里必须要有/
                .antMatchers("/login.html", "/error404.html", "/register.html", "/register", "/success.html").permitAll()
                .antMatchers("/js/**", "/css/**", "/images/*", "/fonts/**", "/**/*.png", "/**/*.jpg", "/**/*.js", "/**/*.css").permitAll()

                //所有的请求都必须被认证，必须登录之后被访问
                .anyRequest().authenticated();

        //关闭csrf防护
        http.csrf().disable();
    }

}
