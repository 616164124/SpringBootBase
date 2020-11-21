/*
  projectName: SpringBootBase
  fileName: UserImp.java
  packageName: com.mikael.service
  date: 2020-10-26
  copyright(c) 2017-2020 xxx公司
 */
package com.mikael.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * @version: V1.0
 * @author: mikael
 * @className: UserImp
 * @packageName: com.mikael.service
 * @description:
 * @data: 2020-10-26
 **/
@Service
public class UserImp implements UserDetailsService {
    @Autowired
    private PasswordEncoder pse;

    //重写 loadUserByUsername
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("自定义逻辑========");
        System.out.println("===========" + username);//username ======  admin
        //从数据库中找到用户跟密码
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //比较密码   123 加密后的
        String encode = pse.encode("123");
        System.out.println(encode);
        //commaSeparatedStringToAuthorityList  内的角色配置有严格要求("ROLE_A, ROLE_B, ROLE_C")
        return new User(username, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,ROLE_"));
    }
}
