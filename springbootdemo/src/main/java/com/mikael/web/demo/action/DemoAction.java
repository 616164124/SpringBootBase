package com.mikael.web.demo.action;


import com.mikael.utils.respon.CodeEnum;
import com.mikael.utils.respon.ServiceResult;
import com.mikael.web.demo.domain.admin;
import com.mikael.web.demo.service.methodService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoAction {


    @Resource(name = "adminServiceImpl")
    private com.mikael.web.demo.service.adminService adminService;

    @RequestMapping(value = "/selectAdmin", method = RequestMethod.GET)
    public List<admin> selectAdmin() {
        List<admin> map = adminService.selectAdmin();
        return map;
    }

    @RequestMapping(value = "/selectAdmin1", method = RequestMethod.GET)
    public List<admin> selectAdmi1n(@RequestBody @Validated admin admin) {
        List<admin> map = adminService.selectAdmin();
        return map;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public void errorTest() throws Exception {
        System.out.println("========");
        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
        Exception exception = new Exception("错误异常科技");
        String s = MDC.get(UUID.randomUUID().toString());
        log.error("错误码{},数据校验异常：{}，异常类型：{}", s, CodeEnum.ERROR.getCode(), exception.getMessage(), exception.getCause(), exception);

        throw new Exception();
    }

    @RequestMapping(value = "/advice01", method = RequestMethod.GET)
    public ServiceResult advice01(@RequestBody admin admin) {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        hashMap.size();
        hashMap.put("s", "s");
        return new ServiceResult(200, "success", null);
    }

    //策略模式
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public ServiceResult method() {
        methodService bean = applicationContext.getBean("Wx", methodService.class);
        return new ServiceResult(200, bean.pay(), null);
    }


    public static void main(String[] args) {
        //不实施该方案
        //初始化为123147 以后可能有年份也可能没有
        String c = "847622782405790831";
        String num = "123456";
        String year = "2024";
        String key = c.substring(c.length() - 4);
        System.out.println(key);
        BigDecimal key_bigDecimal = new BigDecimal(key);
        BigDecimal bigDecimal = new BigDecimal(num);
        String s = bigDecimal.add(key_bigDecimal).add(new BigDecimal(year)).toString();
        System.out.println(s);


        String a = "{name:hua}";


        System.out.println(HttpStatus.LOCKED.value() + "==" + HttpStatus.LOCKED.getReasonPhrase());

    }

}
