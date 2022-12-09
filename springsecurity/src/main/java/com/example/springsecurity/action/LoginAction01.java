package com.example.springsecurity.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction01 {
    @RequestMapping(value = "/login")
    public String login(){

        return "redirect:success";
    }


    @RequestMapping(value = "/main")
    public String main(){

        return "redirect:success.html";
    }

    @RequestMapping(value = "/error404")
    public String error(){
        System.out.println("error404");
        return "redirect:error404.html";
    }



}
