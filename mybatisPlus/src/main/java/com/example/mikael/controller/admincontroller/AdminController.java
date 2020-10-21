/**
 * projectName: SpringBootBase   
 * fileName: AdminController.java  
 * packageName: com.example.mikael.controller.admincontroller   
 * date: 2020-10-20
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.controller.admincontroller;

import com.example.mikael.dao.admindao.AdminDao;
import com.example.mikael.entity.admin.Admin;
import com.example.mikael.response.Meta;
import com.example.mikael.response.ResponseSource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    private AdminDao adminDao;

    @GetMapping(value = "getId/{id}")
    public ResponseSource<Admin> getAmdinById(@PathVariable("id") String id) {
        Admin admin = adminDao.selectById(id);
        return new ResponseSource<Admin>(admin);
    }

    @PostMapping(value = "Inster")
    public boolean insterAdmin() {
        Admin admin = new Admin();
        admin.setId(45).setPassword("976837").setUsername("kkkkkk");
        if (adminDao.insert(admin) < 1) {
            return false;
        }
        return true;
    }

}
