package com.mikael.web.demo.action;


import com.mikael.web.demo.domain.admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoAction {

    private static final Logger Log = LoggerFactory.getLogger(DemoAction.class);

    @Resource(name = "adminServiceImpl")
    private com.mikael.web.demo.service.adminService adminService;

    @RequestMapping(value = "/selectAdmin",method = RequestMethod.GET)
    public List<admin> selectAdmin(){
        List<admin> map = adminService.selectAdmin();
        return map;
    }
    @RequestMapping(value = "/selectAdmin1",method = RequestMethod.GET)
    public List<admin> selectAdmi1n(@RequestBody @Validated admin admin){
        List<admin> map = adminService.selectAdmin();
        return map;
    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public void errorTest() throws Exception {
        System.out.println("========");
        throw new Exception();
    }

}
