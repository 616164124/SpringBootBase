package com.example.springsecurity.securityconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServieImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServieImpl.class);
    @Resource
    private PasswordEncoder pwd;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        log.info("执行loadUserByUsername");
        //1、查询数据库判断用户名是否存在，
        if(!"admin".equals(s)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //2、把查询出来的密码，进行解析，或者直接把密码放入构造方法
        String encode = pwd.encode("123");

        return new User(s, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
