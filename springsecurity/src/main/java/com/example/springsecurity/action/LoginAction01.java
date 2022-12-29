package com.example.springsecurity.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginAction01 {

    private static final Logger log = LoggerFactory.getLogger(LoginAction01.class);
    @Value("${Pbkdf2}")
    private String key;


    @RequestMapping(value = "/login")
    public String login() {
        System.out.println("login===>");

        return "";
    }


    @RequestMapping(value = "/main")
    public String main() {
        System.out.println("login===>");
        return "redirect:success.html";
    }

    @RequestMapping(value = "/error404")
    public String error() {
        System.out.println("error404");
        return "redirect:error404.html";
    }

    @RequestMapping(value = "register")
    public String doRegister(@RequestParam Map<String, String> params) {
        log.info("params===>" + params.toString());
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        String password = pbkdf2PasswordEncoder.encode(params.get("password"));
        log.info("password===>" + password);
        pbkdf2PasswordEncoder=null;
        return "redirect:success.html";
    }


}
