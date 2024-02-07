package com.mikael.web.demo.service.impl;

import com.mikael.web.demo.domain.admin;
import com.mikael.web.demo.mapper.AdminMapper;
import com.mikael.web.demo.service.methodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("Wx")
public class WxMethod implements methodService {
    private static final Logger Log = LoggerFactory.getLogger(WxMethod.class);
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String pay() {
        List<admin> admins = adminMapper.selectAdminByid("21391cd3");

        return "Wx支付";
    }
}
