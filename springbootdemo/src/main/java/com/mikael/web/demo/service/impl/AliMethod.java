package com.mikael.web.demo.service.impl;

import com.mikael.web.demo.service.methodService;
import org.springframework.stereotype.Service;


@Service("Ali")
public class AliMethod implements methodService {
    @Override
    public String pay() {
        return "Ali支付";
    }
}
