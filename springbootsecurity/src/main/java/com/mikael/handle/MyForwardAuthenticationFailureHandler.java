/*
 * projectName: SpringBootBase
 * fileName: My.java
 * packageName: com.mikael.handle
 * date: 2020-10-29
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.handle;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @version: V1.0
 * @author: mikael
 * @className: My
 * @packageName: com.mikael.handle
 * @description:
 * @data: 2020-10-29
 **/
public class MyForwardAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private String url;

    public MyForwardAuthenticationFailureHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect(url);
    }
}
