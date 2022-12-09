package com.example.springsecurity.action;

import mikael.web.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index")
public class LoginAction02 {

    private static final Logger log = LoggerFactory.getLogger(LoginAction02.class);

    @PostMapping("login")
    public ServiceResult doLogin(@RequestBody LoginBo bo) {
        log.info(bo.toString());

        return null;
    }
}
