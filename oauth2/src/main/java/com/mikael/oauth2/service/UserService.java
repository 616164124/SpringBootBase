/*
 * projectName: SpringBootBase
 * fileName: UserService.java
 * packageName: com.mikael.oauth2
 * date: 2020-10-29
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.oauth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.stereotype.Service;

/*
 * @version: V1.0
 * @author: mikael
 * @className: UserService
 * @packageName: com.mikael.oauth2
 * @description:
 * @data: 2020-10-29
 **/
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String encode = passwordEncoder.encode("123456");
        return new User(username, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
