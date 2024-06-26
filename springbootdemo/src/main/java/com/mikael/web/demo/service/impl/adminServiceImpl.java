package com.mikael.web.demo.service.impl;


import com.mikael.web.demo.domain.Admin;
import com.mikael.web.demo.mapper.AdminMapper;
import com.mikael.web.demo.service.adminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hua
 * @description 针对表【admin】的数据库操作Service实现
 * @createDate 2023-09-24 07:11:01
 */
@Service("adminServiceImpl")
public class adminServiceImpl
        implements adminService {
    @Resource
    private AdminMapper adminMapper;

    public List<Admin> selectAdmin() {
        List<Admin> stringStringMap = adminMapper.selectAdmin();

        return stringStringMap;
    }

}
