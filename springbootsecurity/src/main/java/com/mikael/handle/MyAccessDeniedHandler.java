/*
 * projectName: SpringBootBase
 * fileName: MyAccess.java
 * packageName: com.mikael.handle
 * date: 2020-10-29
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.handle;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @version: V1.0
 * @author: mikael
 * @className: MyAccess
 * @packageName: com.mikael.handle
 * @description:
 * @data: 2020-10-29
 **/
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        //响应状态
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //返回json格式
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("{mes:权限不足}");
        writer.flush();
        writer.close();
    }
}
