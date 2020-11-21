package com.example.mikael.controller.testcontroller;

import com.example.mikael.dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: mikael
 * @data: 2020/11/16
 */
@RequestMapping("test")
@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private TestDao testDao;

    @DeleteMapping("del")
    public void delTestDao() {
        int i = testDao.deleteById(new Long(4));
        logger.error(i + "");
    }

}
