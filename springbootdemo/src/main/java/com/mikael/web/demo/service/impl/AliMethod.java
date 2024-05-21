package com.mikael.web.demo.service.impl;

import com.mikael.web.demo.domain.admin;
import com.mikael.web.demo.mapper.AdminMapper;
import com.mikael.web.demo.service.methodService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("Ali")
public class AliMethod implements methodService {
    private final AdminMapper adminMapper;

    public AliMethod(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }


    @Override
    public String pay() {
        return "Ali支付";
    }

    @Override
    public String say() {
        List<admin> admins = adminMapper.selectAdmin();

        return null;
    }
}
