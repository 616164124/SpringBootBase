package com.mikael.web.demo.service;


import com.mikael.web.demo.domain.Admin;

import java.util.List;

/**
 * @author hua
 * @description 针对表【admin】的数据库操作Service
 * @createDate 2023-09-24 07:11:01
 */
public interface adminService {
    List<Admin> selectAdmin();

}
