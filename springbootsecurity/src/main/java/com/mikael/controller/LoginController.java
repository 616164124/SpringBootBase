/**
 * projectName: SpringBootBase
 * fileName: LoginController.java
 * packageName: com.mikael.controller
 * date: 2020-10-26
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @version: V1.0
 * @author: mikael
 * @className: LoginController
 * @packageName: com.mikael.controller
 * @description:
 * @data: 2020-10-26
 **/
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    /*  @GetMapping("/login")
      public String doLogin(){
          return "login.html";
      }
  */
    @PostMapping("toSuccess")
    public String toSuccess() {
        System.out.println();
        return "redirect:success.html";
    }

    @PostMapping("toError")
    public String toError() {
        System.out.println();
        return "redirect:error.html";
    }

    @PostMapping("showLogin")
    public String showLogin() {
        System.out.println("showLogin=================");
        return "showLogin";
    }


}
