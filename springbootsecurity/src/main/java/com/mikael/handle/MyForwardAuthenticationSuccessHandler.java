/*
 * projectName: SpringBootBase
 * fileName: MyForwardAuthenticationFailureHandler.java
 * packageName: com.mikael.handle
 * date: 2020-10-29
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @version: V1.0
 * @author: mikael
 * @className: MyForwardAuthenticationFailureHandler
 * @packageName: com.mikael.handle
 * @description:
 * @data: 2020-10-29
 **/
public class MyForwardAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public MyForwardAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获取登录ip
        System.out.println(request.getRemoteAddr());
        User principal = (User) authentication.getPrincipal();
        System.out.println(principal.getUsername());

        response.sendRedirect(url);
    }
}
