/**
 * projectName: SpringBootBase   
 * fileName: AdminController.java  
 * packageName: com.example.mikael.controller.admincontroller   
 * date: 2020-10-20
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.controller.admincontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.mikael.dao.admindao.AdminDao;
import com.example.mikael.entity.admin.Admin;
import com.example.mikael.response.ResponseSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @version: V1.0
 * @author: mikael
 * @className: AdminController
 * @packageName: com.example.mikael.controller.admincontroller
 * @description:
 * @data: 2020-10-20
 **/
@RestController
@RequestMapping(value = "admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private AdminDao adminDao;

    @DeleteMapping(value = "getId/{id}")
    public ResponseSource<Admin> getAmdinById(HttpServletRequest request, @PathVariable("id") String id) {

        Admin admin = adminDao.selectById(id);
        redisTemplate.opsForValue().set("name", admin);
        logger.info(request.getMethod());
        redisTemplate.expire("name", 34L, TimeUnit.SECONDS);
        return new ResponseSource<Admin>(admin);
    }

    @PostMapping(value = "Inster")
    public boolean insterAdmin(HttpServletRequest request) {
        Admin admin = new Admin();
        admin.setId(45).setPassword("976837").setUsername("kkkkkk");
        if (adminDao.insert(admin) < 1) {
            return false;
        }
        return true;
    }

    @GetMapping("getId/{id}")
    public Admin getId(@RequestParam("id") String id) {
        String admin_getId = (String) redisTemplate.opsForValue().get("admin_getId_" + id);
        if (admin_getId == null) {
            Admin admin = adminDao.selectById(id);
            //将java对象转化成string类型存入redis中
            String adminJson = JSON.toJSONString(admin);
            redisTemplate.opsForValue().set("admin_getId_" + id, adminJson, 10000, TimeUnit.SECONDS);
            System.out.println("getid");
            return admin;
        }
        //redis中存放的是  "{\"id\":3,\"password\":\"555\",\"username\":\"kk\"}"
        //将redis中的string类型转化成java对象
        return JSONObject.parseObject(admin_getId, Admin.class);
    }


}
