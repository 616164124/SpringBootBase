package com.example.springsecurity.securityconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServieImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServieImpl.class);
    /**
     * 123 跟SecuriytConfig中的要一致
     */
    private Pbkdf2PasswordEncoder pwd = new Pbkdf2PasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        log.info("执行loadUserByUsername");
        //1、查询数据库判断用户名是否存在，
        if (!"admin".equals(s)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        //2、把查询出来的密码，进行解析，或者直接把密码放入构造方法
        //密码加密过程，注册时直接用这个方法来进行加密
        String encode = pwd.encode("123");

        return new User(s, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }

    public static void main(String[] args) {
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        String encode = pbkdf2PasswordEncoder.encode("123");
        System.out.println(encode);
        System.out.println(pbkdf2PasswordEncoder.matches("123", "c4d3ee3cc2de95ccbbdeda07c8669c8c6eca88649eb5f8087c3045978f35f1aef3f4eff1776c755d"));

    }
}
