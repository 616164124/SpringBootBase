/**
 * projectName: SpringBootBase   
 * fileName: LoginController.java  
 * packageName: com.mikael.controller   
 * date: 2020-10-26
 * copyright(c) 2017-2020 xxx公司  
 */
package com.mikael.controller;

import org.springframework.stereotype.Controller;
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
