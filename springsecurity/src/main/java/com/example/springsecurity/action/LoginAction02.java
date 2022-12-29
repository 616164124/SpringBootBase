package com.example.springsecurity.action;

import mikael.web.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/index")
public class LoginAction02 {

    private static final Logger log = LoggerFactory.getLogger(LoginAction02.class);

    @PostMapping("login")
    public ServiceResult doLogin(@RequestBody LoginBo bo) {
        log.info(bo.toString());
        return null;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public void getindex() {
        log.info("get");

    }


}
