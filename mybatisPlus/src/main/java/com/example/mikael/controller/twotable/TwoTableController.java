/**
 * projectName: SpringBootBase   
 * fileName: TwoTableController.java  
 * packageName: com.example.mikael.controller.twotable   
 * date: 2020-10-21
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.controller.twotable;

import com.example.mikael.response.ResponseResult;
import com.example.mikael.service.TwotableService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: mikael
 * @className: TwoTableController
 * @packageName: com.example.mikael.controller.twotable
 * @description:
 * @data: 2020-10-21
 **/
@RestController
@RequestMapping(value = "twotable")
public class TwoTableController {

    @Resource
    private TwotableService twotableService;


    @GetMapping(value = "Twotable")
    public List<Map<String, Object>> getTwotable() {


        List<Map<String, Object>> findAll = twotableService.getFindAll();
        return findAll;
    }
}
