package com.mikael.web.demo.action;


import com.mikael.utils.respon.CodeEnum;
import com.mikael.utils.respon.ResultUtil;
import com.mikael.utils.respon.ServiceResult;
import com.mikael.web.demo.domain.admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

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
        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
        Exception exception = new Exception("错误异常科技");
        String s = MDC.get(UUID.randomUUID().toString());
        Log.error("错误码{},数据校验异常：{}，异常类型：{}",s, CodeEnum.ERROR.getCode(),exception.getMessage(),exception.getCause(),exception);

        throw new Exception();
    }

    @RequestMapping(value = "/advice01",method = RequestMethod.GET)
    public ServiceResult advice01(@RequestBody admin admin){
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        hashMap.size();
        hashMap.put("s", "s");
        return new ServiceResult(200, "success", null);
    }



}
