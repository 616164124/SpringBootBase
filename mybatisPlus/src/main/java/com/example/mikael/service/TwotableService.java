/**
 * projectName: SpringBootBase   
 * fileName: TwotableService.java  
 * packageName: com.example.mikael.service   
 * date: 2020-10-21
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.service;

import com.example.mikael.dao.twotable.TwoTableDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version: V1.0
 * @author: mikael
 * @className: TwotableService
 * @packageName: com.example.mikael.service
 * @description:
 * @data: 2020-10-21
 **/
@Service
public class TwotableService {

    @Resource
    private TwoTableDao twoTableDao;

    public List<Map<String, Object>> getFindAll() {
        PageHelper.startPage(1, 3);
        List<Map<String, Object>> maps = twoTableDao.selectFindall();
        PageInfo pageInfo = new PageInfo(maps);
        System.out.println(pageInfo);

        return maps;
    }
}
