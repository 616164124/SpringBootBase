package com.mikael.web.redis;

import com.mikael.utils.respon.ResultUtil;
import com.mikael.utils.respon.ServiceResult;
import io.lettuce.core.RedisClient;
import org.redisson.RedissonLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.RBatch;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/r")
public class RedisAction {

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/demo01",method = RequestMethod.GET)
    public ServiceResult demo01(){

        redisTemplate.opsForValue().set("12", "sss");

        String o = (String)redisTemplate.opsForValue().get("12");

        return ResultUtil.put(12, o, null);
    }
    //排名
    //
    @RequestMapping(value = "rank",method = RequestMethod.GET)
    public ServiceResult randk(){


        return  ResultUtil.success();
    }

    //redissson
    @RequestMapping(value = "/redissson",method = RequestMethod.GET)
    public ServiceResult redissson(){
        StopWatch stopWatch = new StopWatch();

        return  ResultUtil.success();
    }




}
