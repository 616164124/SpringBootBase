package com.mikael.web.redis;

import com.mikael.utils.respon.ResultUtil;
import com.mikael.utils.respon.ServiceResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/redis")
public class RedisAction {

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/demo01",method = RequestMethod.GET)
    public ServiceResult demo01(){

        redisTemplate.opsForValue().set("12", "sss");
        String o = (String)redisTemplate.opsForValue().get("12");

        return ResultUtil.put(12, o, null);
    }

}
