package com.mikael.web.demo.action;


import com.mikael.web.demo.domain.admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoAction {

    private static final Logger log = LoggerFactory.getLogger(DemoAction.class);

    @Resource(name = "adminServiceImpl")
    private com.mikael.web.demo.service.adminService adminService;

    @RequestMapping(value = "/selectAdmin",method = RequestMethod.GET)
    public List<admin> selectAdmin(){
        List<admin> map = adminService.selectAdmin();
        return map;
    }
}
