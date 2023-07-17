package com.example.springsecurity.action;


import mikael.web.ServiceResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAction {


    @GetMapping("/test01")
    public ServiceResult test01(){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("test01");
        return serviceResult;
    }

}
