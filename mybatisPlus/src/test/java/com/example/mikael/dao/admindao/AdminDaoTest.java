package com.example.mikael.dao.admindao;

import com.example.mikael.dao.admindao.AdminDao;
import com.example.mikael.entity.admin.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class AdminDaoTest {

    @Resource
    private AdminDao adminDao;

    @Test
    public void getAdminById() {
        Admin admin = adminDao.selectById("1");
        System.out.println(admin);

    }
}